package dev.janwillem.collectionapi.dataAccess.dao;

import dev.janwillem.collectionapi.dataAccess.models.Order;
import dev.janwillem.collectionapi.dataAccess.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OrderDAO {
    private final OrderRepository orderRepository;

    public OrderDAO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> findById(UUID id) {
        return this.orderRepository.findById(id);
    }

    public Order saveToDatabase(Order order) {
        return this.orderRepository.save(order);
    }

    public List<Order> getAll() {
        return this.orderRepository.findAll();
    }
}
