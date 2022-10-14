package br.com.ecommerce.ecommerce.Dtos;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

@Data
public class CreateUserRoleDTO {

    @Id
    @GeneratedValue
    private Long idUser;

    private List<Long> idsRoles;
}
