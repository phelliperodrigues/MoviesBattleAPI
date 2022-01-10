package dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = -2156194258694650226L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @OneToOne
    @JoinColumn(name = "user_code")
    private UserSystem user;

    @Column(name = "playing", nullable = false)
    private Boolean playing = false;

    @Column(name = "score")
    private Double score;

    public Player playing() {
        this.setPlaying(true);
        return this;
    }
}