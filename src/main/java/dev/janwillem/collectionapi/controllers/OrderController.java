package dev.janwillem.collectionapi.controllers;

import dev.janwillem.collectionapi.dataAccess.dao.*;
import dev.janwillem.collectionapi.dataAccess.models.*;
import dev.janwillem.collectionapi.payloads.NewOrderProductRequest;
import dev.janwillem.collectionapi.payloads.NewOrderRequest;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderDAO orderRepository;
    @Autowired
    private UserDAO userRepository;
    @Autowired
    private AddressDAO addressRepository;
    @Autowired
    private OrderLineDAO orderLineRepository;
    @Autowired
    private ProductDAO productRepository;


    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('Admin')")
    public List<Order> getHandler() {
        return new ArrayList<>(orderRepository.getAll());
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAnyAuthority('Admin')")
    public ResponseEntity<Order> getHandler(@PathVariable String id) {
        var uuid = UUID.fromString(id);
        var obj = orderRepository.findById(uuid);

        if (obj.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>((Order) Hibernate.unproxy(obj.get()), HttpStatus.OK);
    }

    @PostMapping("")
    @PreAuthorize("permitAll()")
    public ResponseEntity<UUID> postHandler(@RequestBody NewOrderRequest postRequest) {
        User user = new User();
        user.setName(postRequest.getName());
        user = userRepository.saveToDatabase(user);

        Address address = new Address();
        address.setUserId(user.getId());
        address.setStreet(postRequest.getStreet());
        address.setCity(postRequest.getCity());
        address.setZIP(postRequest.getZIP());
        addressRepository.saveToDatabase(address);

        Order order = new Order();
        order.setUserID(user.getId());
        order.setOrderStatus(0);
        order = orderRepository.saveToDatabase(order);

        for (NewOrderProductRequest item: postRequest.getProducts()) {
            Optional<Product> product = productRepository.findById(item.getProductID());
            if (product.isEmpty())
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

            Product productObject = product.get();

            if (productObject.getSupply() < item.getQty()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else {
                productObject.setSupply(productObject.getSupply() - item.getQty());
                productRepository.saveToDatabase(productObject);
            }

            OrderLine orderLine = new OrderLine();
            orderLine.setOrderID(order.getId());
            orderLine.setProductID(item.getProductID());
            orderLine.setProductPrice(product.get().getPrice());
            orderLine.setQty(item.getQty());
            orderLineRepository.saveToDatabase(orderLine);
        }

        return new ResponseEntity<>(order.getId(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAnyAuthority('Admin')")
    public ResponseEntity<Order> putHandler(@PathVariable String id, @RequestBody Order postRequest) {
        var uuid = UUID.fromString(id);
        var dbo = orderRepository.findById(uuid);

        if (!postRequest.getId().equals(uuid) || dbo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var nItem = orderRepository.saveToDatabase(postRequest);

        return new ResponseEntity<>(nItem, HttpStatus.OK);
    }
}
