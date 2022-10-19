package br.com.ecommerce.ecommerce.service;

import br.com.ecommerce.ecommerce.exception.ObjectNotFoundException;
import br.com.ecommerce.ecommerce.persistance.entity.product.ProductModel;
import br.com.ecommerce.ecommerce.persistance.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public ProductModel create(Long id_cat, ProductModel productModel) {
        productModel.setCategoryModel(categoryService.find(id_cat).orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada")));
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
