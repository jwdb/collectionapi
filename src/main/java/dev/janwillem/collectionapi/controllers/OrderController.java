package dev.janwillem.collectionapi.controllers;

import dev.janwillem.collectionapi.dataAccess.dao.*;
import dev.janwillem.collectionapi.dataAccess.models.*;
import dev.janwillem.collectionapi.payloads.OrderProductRequest;
import dev.janwillem.collectionapi.payloads.OrderRequest;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public List<OrderRequest> getHandler() {
        ArrayList<OrderRequest> returnList = new ArrayList<>();
        for (Order order : orderRepository.getAll()) {
            OrderRequest returnRequest = new OrderRequest();
            Optional<User> userOptional = userRepository.findById(order.getUserID());

            if (userOptional.isEmpty()) {
                continue;
            }

            User user = userOptional.get();

            Optional<Address> addressOptional = addressRepository.findByUserId(user.getId());

            if (addressOptional.isEmpty()) {
                continue;
            }

            Address address = addressOptional.get();

            List<OrderLine> orderLines = orderLineRepository.findByOrderId(order.getId());

            returnRequest.setId(order.getId());

            returnRequest.setName(user.getName());
            returnRequest.setCity(address.getCity());
            returnRequest.setStreet(address.getStreet());
            returnRequest.setZIP(address.getZIP());

            List<OrderProductRequest> orderProducts = orderLines
                    .stream()
                    .map(c -> new OrderProductRequest() {{
                        Optional<Product> product = productRepository.findById(c.getProductID());
                        setProductID(c.getProductID());
                        setProductName(product.isPresent() ? product.get().getName() : "");
                        setQty(c.getQty());
                        }})
                    .collect(Collectors.toList());

            returnRequest.setProducts(new ArrayList<>(orderProducts));
            returnList.add(returnRequest);
        }

        return returnList;
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
    public ResponseEntity<UUID> postHandler(@RequestBody OrderRequest postRequest) {
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

        for (OrderProductRequest item: postRequest.getProducts()) {
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
