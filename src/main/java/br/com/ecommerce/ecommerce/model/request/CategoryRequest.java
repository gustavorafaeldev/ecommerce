package br.com.ecommerce.ecommerce.model.request;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
public class CategoryRequest {

    @Column(nullable = false)
    @NotEmpty(message = "Campo obrigatório")
    private String categoryName;

    @Column(nullable = false)
    @NotEmpty(message = "Campo obrigatório")
    private String description;

    private String imageUrl;
}