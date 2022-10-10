package br.com.ecommerce.ecommerce.repository;

import br.com.ecommerce.ecommerce.models.CartItemDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemDtoRepository extends JpaRepository<CartItemDto, Long> {
}
