package dev.phelliperodrigues.moviebattle.infrastructure.db.h2.repositories;

import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserSystem, Long> {
    Optional<UserSystem> findByMail(String mail);
}
