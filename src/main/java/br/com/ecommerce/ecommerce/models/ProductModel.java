package br.com.ecommerce.ecommerce.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
public class ProductModel { 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(length = 255, nullable = false)
    private String description;

    @Column(length = 255, nullable = true)
    private String imageUrl;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 25, nullable = false)
    private double price; 

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel categoryModel;
}
