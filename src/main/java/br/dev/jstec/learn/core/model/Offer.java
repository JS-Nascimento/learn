package br.dev.jstec.learn.core.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "tb_offer")
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;
    @Setter
    private String edition;
    @Setter
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant startMoment;
    @Setter
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant endMoment;
    @Setter
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "offer")
    private List<Resource> resources;

    public Offer(Long id, String edition, Instant startMoment, Instant endMoment, Course course) {
        this.id = id;
        this.edition = edition;
        this.startMoment = startMoment;
        this.endMoment = endMoment;
        this.course = course;
    }
}
