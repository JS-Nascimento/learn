package br.dev.jstec.learn.core.repositories;

import br.dev.jstec.learn.core.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
