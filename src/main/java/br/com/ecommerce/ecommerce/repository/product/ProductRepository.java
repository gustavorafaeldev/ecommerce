package br.com.ecommerce.ecommerce.repository.product;

import br.com.ecommerce.ecommerce.models.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
