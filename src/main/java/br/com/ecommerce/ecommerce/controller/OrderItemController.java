package br.com.ecommerce.ecommerce.controller;

import br.com.ecommerce.ecommerce.persistance.entity.order.OrderItem;
import br.com.ecommerce.ecommerce.service.OrderItemService;
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
    public ResponseEntity<OrderItem> create(@RequestParam(value = "orderId", defaultValue = "0") Long orderId,
                                            @RequestBody OrderItem orderItem,
                                            @RequestParam(value = "productId", defaultValue = "0")Long productId)  {
        OrderItem orderItemSaved = service.create(orderId, productId, orderItem);
        return new ResponseEntity<>(orderItemSaved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderItem>> get(OrderItem orderItem) {
        List<OrderItem> orderItems = service.get();
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }
}
