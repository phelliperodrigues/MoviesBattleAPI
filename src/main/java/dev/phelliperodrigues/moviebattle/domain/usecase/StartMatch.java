package dev.phelliperodrigues.moviebattle.domain.usecase;

import dev.phelliperodrigues.moviebattle.domain.interfaces.facade.UserRepositoryFacade;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Match;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Transient;
import javax.transaction.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class StartMatch {

    private final UserRepositoryFacade userRepositoryFacade;
    private final CreateMatch createMatch;
    @Transactional
    public Match execute(String mail) {
        return userRepositoryFacade.findByMail(mail).map(userSystem -> {
                    if (userSystem.existsPlayer()) {
                        log.info("PLAYER {} ", userSystem.getPlayer().getNickname());
                        return  createMatch.execute(userSystem);
                    } else {
                        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User is not a player! Please create a gamer profile");
                    }
                }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "OPS! Something went wrong starting match"));
    }
}
