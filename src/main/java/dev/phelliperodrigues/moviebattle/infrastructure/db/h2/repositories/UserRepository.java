package dev.phelliperodrigues.moviebattle.infrastructure.db.h2.repositories;

import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SystemUser, Long> {
    Optional<SystemUser> findByMail(String mail);
}
