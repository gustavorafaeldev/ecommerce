package br.com.ecommerce.ecommerce.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;
import lombok.Data;

@Entity
@Data
@Table(name = "categories")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private String description;

    @Column(length = 255, nullable = true)
    private String imageUrl;

    @OneToMany(mappedBy = "categoryModel")
    private List<ProductModel> products = new ArrayList<>();
}
