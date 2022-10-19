package br.com.ecommerce.ecommerce.service;

import br.com.ecommerce.ecommerce.persistance.entity.order.OrderItem;
import br.com.ecommerce.ecommerce.persistance.repository.order.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    private final OrderService orderService;

    private final ProductService productService;

    public OrderItem create(Long id_order, Long id_product, OrderItem orderItem) {
        orderItem.setOrder(orderService.findById(id_order));
        orderItem.setProductModel(productService.findById(id_product));
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> get() {
        return orderItemRepository.findAll();
    }
}
