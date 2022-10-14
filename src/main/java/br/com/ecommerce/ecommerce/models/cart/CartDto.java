package br.com.ecommerce.ecommerce.models.cart;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CartDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalCost;

    @OneToMany(mappedBy = "cartDto")
    private List<CartItemDto> cartItemDtos;
}
