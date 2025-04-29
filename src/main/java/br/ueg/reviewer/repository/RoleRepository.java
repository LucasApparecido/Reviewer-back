package br.ueg.reviewer.repository;

import br.ueg.reviewer.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
