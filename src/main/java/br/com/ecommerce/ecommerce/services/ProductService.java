package br.com.ecommerce.ecommerce.services;

import br.com.ecommerce.ecommerce.exceptions.ObjectNotFoundException;
import br.com.ecommerce.ecommerce.models.ProductModel;
import br.com.ecommerce.ecommerce.repository.ProductRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ProductModel findById(Long id) {
        Optional<ProductModel> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado! Id: "+id + "Tipo: "+ProductModel.class.getName()));
    }

    public void updateData(ProductModel newProduct, ProductModel productModel) {
        newProduct.setName(productModel.getName());
        newProduct.setDescription(productModel.getDescription());
        newProduct.setPrice(productModel.getPrice());
    }

    public ProductModel update(Long id, ProductModel productModel) {
        ProductModel newObj = findById(id);
        updateData(newObj, productModel);
        return productRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        productRepository.deleteById(id);
    }
}
