package br.com.ecommerce.ecommerce.repository;

import br.com.ecommerce.ecommerce.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
