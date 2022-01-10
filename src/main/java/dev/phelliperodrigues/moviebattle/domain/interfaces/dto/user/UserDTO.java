package dev.phelliperodrigues.moviebattle.domain.interfaces.dto.user;

import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.UserSystem;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends User {
    private final UserSystem user;

    public UserDTO(UserSystem users, Collection<? extends GrantedAuthority> authorities) {
        super(users.getMail(), users.getPassword(), authorities);
        this.user = users;
    }

}
