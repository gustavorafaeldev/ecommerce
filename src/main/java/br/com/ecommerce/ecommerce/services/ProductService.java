package br.com.ecommerce.ecommerce.services;

import br.com.ecommerce.ecommerce.models.ProductModel;
import br.com.ecommerce.ecommerce.repository.CategoryRepository;
import br.com.ecommerce.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public ProductModel create(Long id_cat, ProductModel productModel) {
        productModel.setCategoryModel(categoryService.findById(id_cat));
        return productRepository.save(productModel);
    }
}
