package dev.phelliperodrigues.moviebattle.domain.interfaces.facade;

import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.UserSystem;

import java.util.Optional;

public interface UserRepositoryFacade {
    Optional<UserSystem> findByMail(String mail);
}
