package br.com.ecommerce.ecommerce.persistance.repository.user;

import br.com.ecommerce.ecommerce.persistance.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
