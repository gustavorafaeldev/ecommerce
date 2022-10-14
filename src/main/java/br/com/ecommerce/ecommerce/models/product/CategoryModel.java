package br.com.ecommerce.ecommerce.models.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import br.com.ecommerce.ecommerce.models.product.ProductModel;
import lombok.Data;

@Entity
@Data
@Table(name = "categories")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", nullable = false)
    @NotEmpty(message = "Campo obrigatório")
    private String categoryName;


    @Column(nullable = false)
    @NotEmpty(message = "Campo obrigatório")
    private String description;

    @Column(length = 255, nullable = true)
    private String imageUrl;

    @OneToMany(mappedBy = "categoryModel")
    private List<ProductModel> products = new ArrayList<>();
}
