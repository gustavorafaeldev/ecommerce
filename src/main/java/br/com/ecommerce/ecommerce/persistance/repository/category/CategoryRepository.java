package br.com.ecommerce.ecommerce.persistance.repository.category;

import br.com.ecommerce.ecommerce.persistance.entity.product.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

}
