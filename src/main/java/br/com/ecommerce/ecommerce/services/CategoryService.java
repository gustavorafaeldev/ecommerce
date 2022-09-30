package br.com.ecommerce.ecommerce.services;

import br.com.ecommerce.ecommerce.models.CategoryModel;
import br.com.ecommerce.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryModel create(CategoryModel categoryModel) {
        return categoryRepository.save(categoryModel);
    }

    public CategoryModel findById(Long id) {
        return categoryRepository.findById(id);
    }
}
