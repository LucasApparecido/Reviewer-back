package br.ueg.reviewer.repository;

import br.ueg.reviewer.entities.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLogRepository extends JpaRepository<UserLog, Long> {
}