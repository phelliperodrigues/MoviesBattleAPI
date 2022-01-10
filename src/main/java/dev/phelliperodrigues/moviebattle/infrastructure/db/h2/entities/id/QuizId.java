package dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.id;

import dev.phelliperodrigues.moviebattle.infrastructure.db.h2.entities.Match;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizId implements Serializable {

    @Serial
    private static final long serialVersionUID = -6937419550061917466L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "match_id")
    private Match match;

    @Column(name = "sequence_game")
    @Generated(GenerationTime.INSERT)
    private Integer sequence;
}
