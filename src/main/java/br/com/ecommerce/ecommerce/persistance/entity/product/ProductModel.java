package br.com.ecommerce.ecommerce.persistance.entity.product;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
public class ProductModel { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 255, nullable = false)
    @NotEmpty(message = "Campo obrigatório")
    private String description;

    @Column(length = 255, nullable = true)
    private String imageUrl;

    @Column(length = 255, nullable = false)
    @NotEmpty(message = "Campo obrigatório")
    private String name;

    @Column(length = 25, nullable = false)
    private double price; 

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel categoryModel;

}
