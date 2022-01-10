package dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "matches")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Match implements Serializable {

    @Serial
    private static final long serialVersionUID = 7396184194447227754L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Player.class)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Quiz.class)
    @OrderBy("id.sequence")
    private List<Quiz> quizzes;

    @Column(name = "playing")
    private Boolean playing = false;

    @Column(name = "score")
    private Double score;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    public Optional<Quiz> getNextQuiz(Integer quizId) {
        return this.quizzes.stream().filter(quiz -> quiz.isCurrentById(quizId)).collect(Collectors.toList()).stream().findFirst();
    }


}