package br.com.ecommerce.ecommerce.service;

import br.com.ecommerce.ecommerce.persistance.entity.product.CategoryModel;
import br.com.ecommerce.ecommerce.persistance.entity.product.ProductModel;
import br.com.ecommerce.ecommerce.persistance.repository.category.CategoryRepository;
import br.com.ecommerce.ecommerce.persistance.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public void instanciaBaseDeDados() {
        CategoryModel cat1 = new CategoryModel();
        cat1.setCategoryName("Eletrônicos");
        cat1.setDescription("Produtos de informática e eletrônicos");

        CategoryModel cat2 = new CategoryModel();
        cat2.setCategoryName("Diversos");
        cat2.setDescription("Produtos de diferentes categorias");

        ProductModel prod1 = new ProductModel();
        prod1.setName("Computador All in One");
        prod1.setDescription("Computador core i5, 8gb RAM");
        prod1.setPrice(2999.80d);

        ProductModel prod2 = new ProductModel();
        prod2.setName("Teclado gamer");
        prod2.setDescription("Teclado gamer mecâncico readragon");
        prod2.setPrice(199.8d);

        ProductModel prod3 = new ProductModel();
        prod3.setName("Tesoura");
        prod3.setDescription("Tesoura tradicional grande");
        prod3.setPrice(5.99d);

        ProductModel prod4 = new ProductModel();
        prod4.setName("Porta canetas");
        prod4.setDescription("Porta canetas decorativo");
        prod4.setPrice(11.85d);

        cat1.getProducts().addAll(Arrays.asList(prod1, prod2));
        cat2.getProducts().addAll(Arrays.asList(prod3, prod4));

        this.categoryRepository.saveAll(Arrays.asList(cat1,cat2));
        this.productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));
    }
}
