package dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities;

import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.id.QuizId;
import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(
        name = "quizzes",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"movie_one_id", "movie_two_id"}
        )
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Quiz implements Serializable {

    @Serial
    private static final long serialVersionUID = 4948743232141345696L;
    @EmbeddedId
    private QuizId id;

    @ManyToOne
    @JoinColumn(name = "movie_one_id")
    private Movie movieOne;

    @ManyToOne
    @JoinColumn(name = "movie_two_id")
    private Movie movieTwo;

    @Column(name = "movie_id_selected")
    private Long movieIdSelected;

    @Column(name = "is_correct_answer")
    private Boolean correctAnswer;

    public boolean isCurrent(Quiz quiz) {
        return this.movieIdSelected == null;
    }

    public boolean isCurrentById(Integer quizId) {
        return this.movieIdSelected == null && quizId.equals(this.id.getSequence());
    }
}