package br.com.ecommerce.ecommerce.mapper.request;

import br.com.ecommerce.ecommerce.mapper.Mapper;
import br.com.ecommerce.ecommerce.model.request.CategoryRequest;
import br.com.ecommerce.ecommerce.persistance.entity.product.CategoryModel;
import org.springframework.stereotype.Component;

@Component
public class CategoryRequestMapper implements Mapper<CategoryRequest, CategoryModel> {

    @Override
    public CategoryModel map(CategoryRequest categoryRequest) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategoryName(categoryRequest.getCategoryName());
        categoryModel.setDescription(categoryRequest.getDescription());
        categoryModel.setImageUrl(categoryRequest.getImageUrl());
        return categoryModel;
    }
}
