package br.com.ecommerce.ecommerce.controller.user;

import br.com.ecommerce.ecommerce.models.user.Role;
import br.com.ecommerce.ecommerce.services.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role obj = roleService.createRole(role);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }


}
