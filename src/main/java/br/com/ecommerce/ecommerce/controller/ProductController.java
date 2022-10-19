package br.com.ecommerce.ecommerce.controller;

import br.com.ecommerce.ecommerce.persistance.entity.product.ProductModel;
import br.com.ecommerce.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductModel>> findAll() {
        List<ProductModel> productModelList = productService.findAll();
        return new ResponseEntity<>(productModelList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductModel> findById(@PathVariable Long id) {
        ProductModel productModel = productService.findById(id);
        return new ResponseEntity<>(productModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductModel> create(@Valid @RequestParam(value = "idCat", defaultValue = "0") Long idCat,
                                               @RequestBody ProductModel productModel) {
        ProductModel obj = productService.create(idCat, productModel);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductModel> update(@Valid @PathVariable Long id, @RequestBody ProductModel productModel) {
        ProductModel obj = productService.update(id, productModel);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductModel> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
