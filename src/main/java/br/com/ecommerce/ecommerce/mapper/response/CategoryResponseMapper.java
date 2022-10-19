package br.com.ecommerce.ecommerce.mapper.response;

import br.com.ecommerce.ecommerce.mapper.Mapper;
import br.com.ecommerce.ecommerce.model.response.CategoryResponse;
import br.com.ecommerce.ecommerce.persistance.entity.product.CategoryModel;

public class CategoryResponseMapper implements Mapper<CategoryModel, CategoryResponse> {

    @Override
    public CategoryResponse map(CategoryModel categoryModel) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(categoryModel.getId());
        categoryResponse.setCategoryName(categoryModel.getCategoryName());
        categoryResponse.setDescription(categoryModel.getDescription());
        categoryResponse.setImageUrl(categoryModel.getImageUrl());
        return categoryResponse;
    }
}
