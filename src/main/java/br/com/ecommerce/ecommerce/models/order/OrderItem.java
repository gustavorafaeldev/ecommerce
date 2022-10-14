package br.com.ecommerce.ecommerce.models.order;

import br.com.ecommerce.ecommerce.models.product.ProductModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdDate;

    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private ProductModel productModel;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;
}
