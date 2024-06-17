package br.com.application.session_demo.repository;

import br.com.application.session_demo.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, String> {

    Optional<Session> findByName(String name);
}
