package dev.phelliperodrigues.moviebattle.domain.interfaces.facade;

import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.SystemUser;

import java.util.Optional;

public interface UserRepositoryFacade {
    Optional<SystemUser> findByMail(String mail);
}
