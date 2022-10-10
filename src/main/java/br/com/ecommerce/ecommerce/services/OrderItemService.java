package br.com.ecommerce.ecommerce.services;

import br.com.ecommerce.ecommerce.models.Order;
import br.com.ecommerce.ecommerce.models.OrderItem;
import br.com.ecommerce.ecommerce.repository.OrderItemRepository;
import br.com.ecommerce.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderService orderService;

    public OrderItem create(Long id_order, OrderItem orderItem) {
        orderItem.setOrder(orderService.findById(id_order));
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> get() {
        return orderItemRepository.findAll();
    }
}
