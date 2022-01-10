package dev.phelliperodrigues.moviebattle.infrastructure.db.h2.facades;

import dev.phelliperodrigues.moviebattle.domain.interfaces.facade.UserRepositoryFacade;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.UserSystem;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRepositoryFacadeImpl implements UserRepositoryFacade {

    private final UserRepository repository;

    @Override
    public Optional<UserSystem> findByMail(String mail) {
        return repository.findByMail(mail);
    }
}
