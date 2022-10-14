package br.com.ecommerce.ecommerce.models.user;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty(message = "Campo obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotEmpty(message = "Campo obrigatório")
    private String firstName;

    @NotEmpty(message = "Campo obrigatório")
    private String lastName;

    @NotEmpty(message = "Campo obrigatório")
    private String password;

    private enum role {
        user, manager, admin
    }

}
