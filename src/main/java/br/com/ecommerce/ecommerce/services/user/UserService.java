package br.com.ecommerce.ecommerce.services.user;

import br.com.ecommerce.ecommerce.models.user.User;
import br.com.ecommerce.ecommerce.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
