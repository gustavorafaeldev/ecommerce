package br.com.ecommerce.ecommerce.repository.cart;

import br.com.ecommerce.ecommerce.models.cart.CartDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDtoRepository extends JpaRepository<CartDto, Long> {
}
