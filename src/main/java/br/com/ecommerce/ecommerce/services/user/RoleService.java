package br.com.ecommerce.ecommerce.services.user;

import br.com.ecommerce.ecommerce.Dtos.CreateUserRoleDTO;
import br.com.ecommerce.ecommerce.models.user.Role;
import br.com.ecommerce.ecommerce.models.user.User;
import br.com.ecommerce.ecommerce.repository.user.RoleRepository;
import br.com.ecommerce.ecommerce.repository.user.UserRepository;
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
        List<Role> roles = new ArrayList<>();

        if (userExists.isEmpty()) {
            throw new Error("Usuário não existe");
        }

        roles = createUserRoleDTO.getIdsRoles().stream().map(role -> {
            return new Role(role);
        }).collect(Collectors.toList());

        User user = userExists.get();

        user.setRoles(roles);

        userRepository.save(user);

        return user;
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
}
