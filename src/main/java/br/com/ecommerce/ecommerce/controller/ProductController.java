package br.com.ecommerce.ecommerce.controller;

import br.com.ecommerce.ecommerce.models.ProductModel;
import br.com.ecommerce.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductModel>> findAll() {
        List<ProductModel> list = productService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductModel> create(@RequestParam(value = "category", defaultValue = "0") Long id_cat,
                                               @RequestBody ProductModel productModel) {
        ProductModel obj = productService.create(id_cat, productModel);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductModel> update(@PathVariable Long id, @RequestBody ProductModel productModel) {
        ProductModel obj = productService.update(id, productModel);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }
}
