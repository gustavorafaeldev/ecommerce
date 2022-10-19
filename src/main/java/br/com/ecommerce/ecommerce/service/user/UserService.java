package br.com.ecommerce.ecommerce.service.user;

import br.com.ecommerce.ecommerce.persistance.entity.user.User;
import br.com.ecommerce.ecommerce.persistance.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User create(User user) {
        User existsUser = userRepository.findByEmail(user.getEmail());

        if(existsUser != null) {
            throw new Error("Já existe um usuário com esse email.");
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));

        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
