package br.com.ecommerce.ecommerce.Dtos;

import br.com.ecommerce.ecommerce.models.CategoryModel;
import lombok.Data;

import javax.persistence.Column;

@Data
public class CategoryDTO {

    private Long id;

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private String description;

    private String imageUrl;

    public CategoryDTO() {
    }

    public CategoryDTO(CategoryModel categoryModel) {
        super();
        this.id = categoryModel.getId();
        this.categoryName = categoryModel.getCategoryName();
        this.description = categoryModel.getDescription();
        this.imageUrl = categoryModel.getImageUrl();
    }
}
