package br.com.ecommerce.ecommerce.controller;

import br.com.ecommerce.ecommerce.models.OrderItem;
import br.com.ecommerce.ecommerce.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService service;

    @PostMapping("/add")
    public ResponseEntity<OrderItem> create(@RequestParam(value = "order", defaultValue = "0") Long id_order,
                                            @RequestBody OrderItem orderItem) {
        OrderItem obj = service.create(id_order, orderItem);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderItem>> get(OrderItem orderItem) {
        List<OrderItem> list = service.get();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
