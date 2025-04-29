package br.ueg.reviewer.repository;

import br.ueg.reviewer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
    User findByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByLogin(String login);
}
