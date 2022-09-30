package br.com.ecommerce.ecommerce.controller;

import br.com.ecommerce.ecommerce.Dtos.CategoryDTO;
import br.com.ecommerce.ecommerce.models.CategoryModel;
import br.com.ecommerce.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategories")
    public ResponseEntity<List<CategoryDTO>> findAll () {
        List<CategoryModel> list = categoryService.findAll();
        List<CategoryDTO> listDTO = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryModel> create(@RequestBody CategoryModel categoryModel) {
        CategoryModel obj = categoryService.create(categoryModel);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoryModel> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryModel> update(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
        CategoryModel obj = categoryService.update(id, categoryDTO);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }
}
