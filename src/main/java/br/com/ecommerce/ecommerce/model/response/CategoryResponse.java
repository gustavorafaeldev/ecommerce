package br.com.ecommerce.ecommerce.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CategoryResponse {

    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "Campo obrigatório")
    private String categoryName;

    @Column(nullable = false)
    @NotEmpty(message = "Campo obrigatório")
    private String description;

    private String imageUrl;

}