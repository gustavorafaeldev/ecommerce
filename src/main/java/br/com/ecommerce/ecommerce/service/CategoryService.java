package br.com.ecommerce.ecommerce.service;

import br.com.ecommerce.ecommerce.exception.DataIntegrityViolationException;
import br.com.ecommerce.ecommerce.mapper.Mapper;
import br.com.ecommerce.ecommerce.model.request.CategoryRequest;
import br.com.ecommerce.ecommerce.model.response.CategoryResponse;
import br.com.ecommerce.ecommerce.persistance.entity.product.CategoryModel;
import br.com.ecommerce.ecommerce.persistance.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements AbstractService<CategoryRequest, CategoryResponse>{

    private final CategoryRepository categoryRepository;

    private final Mapper<CategoryRequest, CategoryModel> categoryRequestMapper;
    private final Mapper<CategoryModel, CategoryResponse> categoryResponseMapper;

    public CategoryResponse create(CategoryRequest categoryRequest) {
        var categoryModel = this.categoryRequestMapper.map(categoryRequest);
        var categoryModelSaved = this.categoryRepository.save(categoryModel);
        return this.categoryResponseMapper.map(categoryModelSaved);
    }

    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll().stream()
                .map(categoryResponseMapper::map)
                .toList();
    }

    public Optional<CategoryResponse> findById(Long id) {
        return categoryRepository.findById(id).map(this.categoryResponseMapper::map);
    }

    protected Optional<CategoryModel> find(Long id) {
        return categoryRepository.findById(id);
    }

    public CategoryResponse update(Long id, CategoryRequest categoryRequest) {
        CategoryModel categoryModel = this.categoryRequestMapper.map(categoryRequest);
        categoryModel.setId(id);

        CategoryModel categoryModelUpdated = categoryRepository.save(categoryModel);
        return this.categoryResponseMapper.map(categoryModelUpdated);
    }

    public void delete(Long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Categoria não pode ser deletada, possui produtos associados.");
        }
    }
}