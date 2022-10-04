package br.com.ecommerce.ecommerce.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Order {

    private String createdDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    private double totalPrice;
}
