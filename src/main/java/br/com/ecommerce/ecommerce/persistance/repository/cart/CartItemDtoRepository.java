package br.com.ecommerce.ecommerce.persistance.repository.cart;

import br.com.ecommerce.ecommerce.persistance.entity.cart.CartItemDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemDtoRepository extends JpaRepository<CartItemDto, Long> {
}
