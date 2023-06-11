package br.dev.jstec.learn.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_lesson")
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;
    @Setter
    private String title;
    @Setter
    private Integer position;
    @Setter
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToMany
    @JoinTable(
            name = "tb_lessons_done",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id"),
                    @JoinColumn(name = "offer_id")
            }
            )
    private Set<Enrollment> enrollmentsDone = new HashSet<>();

    public Lesson(Long id, String title, Integer position, Section section) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.section = section;
    }

}
