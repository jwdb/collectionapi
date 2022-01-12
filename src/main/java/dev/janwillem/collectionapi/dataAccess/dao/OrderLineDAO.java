package dev.janwillem.collectionapi.dataAccess.dao;

import dev.janwillem.collectionapi.dataAccess.models.OrderLine;
import dev.janwillem.collectionapi.dataAccess.repository.OrderLineRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderLineDAO {
    private OrderLineRepository orderLineRepository;

    public OrderLineDAO(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    public Optional<OrderLine> findById(UUID id) {
        return this.orderLineRepository.findById(id);
    }

    public OrderLine saveToDatabase(OrderLine orderLine) {
        return this.orderLineRepository.save(orderLine);
    }

    public List<OrderLine> saveAllToDatabase(List<OrderLine> orderLines) {
        return this.orderLineRepository.saveAll(orderLines);
    }

    public List<OrderLine> findByOrderId(UUID orderId) {
        return this.orderLineRepository.findAllByOrderID(orderId);
    }
}