package br.com.ecommerce.ecommerce.repository;

import br.com.ecommerce.ecommerce.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
