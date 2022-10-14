package br.com.ecommerce.ecommerce.repository.category;

import br.com.ecommerce.ecommerce.models.product.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

}
