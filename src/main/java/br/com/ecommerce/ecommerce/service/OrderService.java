package br.com.ecommerce.ecommerce.service;

import br.com.ecommerce.ecommerce.exception.ObjectNotFoundException;
import br.com.ecommerce.ecommerce.persistance.entity.order.Order;
import br.com.ecommerce.ecommerce.persistance.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public Order create(Order order) {

        return orderRepository.save(order);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
