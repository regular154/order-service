package snowboard.orderservice.service;

import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.stereotype.Service;
import snowboard.orderservice.controller.OrderNotFoundException;
import snowboard.orderservice.domain.Order;
import snowboard.orderservice.repo.OrderRepo;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order getById(String id) {
        return orderRepo.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    public Order add(Order order) {
        return orderRepo.save(order);
    }

    public boolean deleteById(String id) {
        try {
            orderRepo.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
