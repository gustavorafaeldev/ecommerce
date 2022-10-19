package br.com.ecommerce.ecommerce.persistance.repository.order;

import br.com.ecommerce.ecommerce.persistance.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
