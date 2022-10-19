package br.com.ecommerce.ecommerce.persistance.repository.product;

import br.com.ecommerce.ecommerce.persistance.entity.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
