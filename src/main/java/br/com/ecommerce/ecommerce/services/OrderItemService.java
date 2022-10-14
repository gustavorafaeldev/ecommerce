package br.com.ecommerce.ecommerce.services;

import br.com.ecommerce.ecommerce.models.order.OrderItem;
import br.com.ecommerce.ecommerce.repository.order.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;


    public OrderItem create(Long id_order, Long id_product, OrderItem orderItem) {
        orderItem.setOrder(orderService.findById(id_order));
        orderItem.setProductModel(productService.findById(id_product));
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> get() {
        return orderItemRepository.findAll();
    }
}
