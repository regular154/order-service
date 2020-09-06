package snowboard.orderservice.controller;

import org.springframework.web.bind.annotation.*;
import snowboard.orderservice.domain.Order;
import snowboard.orderservice.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/{id}")
    public Order getById(@PathVariable("id") String id) {
        return orderService.getById(id);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping
    public Order add(@RequestBody Order order) {
        return orderService.add(order);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteById(@PathVariable String id) {
        return orderService.deleteById(id);
    }
}
