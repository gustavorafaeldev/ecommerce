package br.com.ecommerce.ecommerce.repository.order;

import br.com.ecommerce.ecommerce.models.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
