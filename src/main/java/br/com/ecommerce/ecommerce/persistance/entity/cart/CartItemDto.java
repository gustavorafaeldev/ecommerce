package br.com.ecommerce.ecommerce.persistance.entity.cart;

import br.com.ecommerce.ecommerce.persistance.entity.product.ProductModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class CartItemDto implements Serializable {

    private static final long serialVersionUID = 1L;

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
    @JsonIgnore
    private CartDto cartDto;
}
