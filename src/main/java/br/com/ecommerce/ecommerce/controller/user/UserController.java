package br.com.ecommerce.ecommerce.controller.user;

import br.com.ecommerce.ecommerce.dto.CreateUserRoleDTO;
import br.com.ecommerce.ecommerce.persistance.entity.user.User;
import br.com.ecommerce.ecommerce.service.user.RoleService;
import br.com.ecommerce.ecommerce.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        User obj = userService.create(user);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> userList = userService.getAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping("/role")
    public ResponseEntity<User> role(@RequestBody CreateUserRoleDTO createUserRoleDTO) {
        User obj = roleService.create(createUserRoleDTO);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }
}
