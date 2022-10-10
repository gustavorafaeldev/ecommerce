package br.com.ecommerce.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CartItemDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;
    private int quantity;

    @OneToOne
    @JoinColumn(name = "product_model_id")
    @JsonIgnore
    private ProductModel productModel;

    @ManyToOne
    @JoinColumn(name = "cartItemDtos")
    private CartDto cartDto;

}
