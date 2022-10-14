package br.com.ecommerce.ecommerce.repository.user;

import br.com.ecommerce.ecommerce.models.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
