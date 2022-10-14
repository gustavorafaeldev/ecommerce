package br.com.ecommerce.ecommerce.controller;

import br.com.ecommerce.ecommerce.models.order.Order;
import br.com.ecommerce.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Order> create(@RequestBody Order order){
        Order obj = orderService.create(order);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = orderService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = orderService.findById(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
