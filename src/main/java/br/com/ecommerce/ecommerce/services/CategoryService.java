package br.com.ecommerce.ecommerce.services;

import br.com.ecommerce.ecommerce.Dtos.CategoryDTO;
import br.com.ecommerce.ecommerce.exceptions.ObjectNotFoundException;
import br.com.ecommerce.ecommerce.models.CategoryModel;
import br.com.ecommerce.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<CategoryModel> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() ->
                new ObjectNotFoundException("Categoria não encontrada! Id: "+ id + "Tipo: "+ CategoryModel.class.getName()));
    }

    public void delete(Long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new br.com.ecommerce.ecommerce.exceptions.DataIntegrityViolationException("" +
                    "Categoria não pode ser deletada, possui produtos associados.");
        }
    }

    public CategoryModel update(Long id, CategoryDTO categoryDTO) {
        CategoryModel newObj = findById(id);
        newObj.setCategoryName(categoryDTO.getCategoryName());
        newObj.setDescription(categoryDTO.getDescription());
        return categoryRepository.save(newObj);
    }
}
