package dev.phelliperodrigues.moviebattle.domain.usecase;

import dev.phelliperodrigues.moviebattle.domain.interfaces.dto.user.UserDTO;
import dev.phelliperodrigues.moviebattle.domain.interfaces.facade.UserRepositoryFacade;
import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.SystemUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class LoadUserByUsername implements UserDetailsService {

    private final UserRepositoryFacade repository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        var user = repository.findByMail(mail).orElseThrow(() -> new UsernameNotFoundException("Usuario e/ou senha incorretos"));
        return new UserDTO(user, getRoles(user));
    }

    private Collection<? extends GrantedAuthority> getRoles(SystemUser users) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        users.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority((role.getDescription().toUpperCase()))));
        return authorities;
    }
}