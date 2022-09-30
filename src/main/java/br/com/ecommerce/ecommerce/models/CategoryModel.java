package br.com.ecommerce.ecommerce.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;
import lombok.Data;

@Entity
@Data
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255, nullable = false)
    private String categoryName;

    @Column(length = 255, nullable = false)
    private String description;

    @Column(length = 255, nullable = true)
    private String imageUrl;

    @OneToMany(mappedBy = "categoryModel")
    private List<ProductModel> products = new ArrayList<>();
}
