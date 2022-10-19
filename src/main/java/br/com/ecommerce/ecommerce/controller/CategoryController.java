package br.com.ecommerce.ecommerce.controller;

import br.com.ecommerce.ecommerce.exception.ObjectNotFoundException;
import br.com.ecommerce.ecommerce.model.request.CategoryRequest;
import br.com.ecommerce.ecommerce.model.response.CategoryResponse;
import br.com.ecommerce.ecommerce.persistance.entity.product.CategoryModel;
import br.com.ecommerce.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@Valid @RequestBody CategoryRequest categoryRequest) {
        CategoryResponse categoryResponse = categoryService.create(categoryRequest);
        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll() {
        List<CategoryResponse> categoryResponseList = categoryService.findAll();
        return new ResponseEntity<>(categoryResponseList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() ->
                    new ObjectNotFoundException("Categoria não encontrada! Id: "+ id + "Tipo: "+ CategoryModel.class.getName())
                );
    }

    @PutMapping("update/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @RequestBody @Valid CategoryRequest categoryRequest){
        CategoryResponse categoryResponse = categoryService.update(id, categoryRequest);
        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}