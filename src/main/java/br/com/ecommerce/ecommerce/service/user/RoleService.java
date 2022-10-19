package br.com.ecommerce.ecommerce.service.user;

import br.com.ecommerce.ecommerce.dto.CreateUserRoleDTO;
import br.com.ecommerce.ecommerce.persistance.entity.user.Role;
import br.com.ecommerce.ecommerce.persistance.entity.user.User;
import br.com.ecommerce.ecommerce.persistance.repository.user.RoleRepository;
import br.com.ecommerce.ecommerce.persistance.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User create(CreateUserRoleDTO createUserRoleDTO) {
        Optional<User> userExists = userRepository.findById(createUserRoleDTO.getIdUser());

        if (userExists.isEmpty()) {
            throw new Error("Usuário não existe");
        }

        User user = userExists.get();

        user.setRoles(createUserRoleDTO.getIdsRoles().stream().map(Role::new).toList());

        userRepository.save(user);
        return user;
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
}
