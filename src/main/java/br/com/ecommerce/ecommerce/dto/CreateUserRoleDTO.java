package br.com.ecommerce.ecommerce.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
public class CreateUserRoleDTO {

    @Id
    @GeneratedValue
    private Long idUser;

    private List<Long> idsRoles;
}
