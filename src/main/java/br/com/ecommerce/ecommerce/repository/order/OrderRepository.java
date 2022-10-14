package br.com.ecommerce.ecommerce.repository.order;

import br.com.ecommerce.ecommerce.models.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
