package br.com.ecommerce.ecommerce.persistance.repository.user;

import br.com.ecommerce.ecommerce.persistance.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
