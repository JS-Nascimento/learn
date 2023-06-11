package br.dev.jstec.learn.core.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_topic")
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;
    @Setter
    private String title;

    @Column(columnDefinition = "TEXT")
    @Setter
    private String body;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Setter
    private Instant moment;
    @ManyToOne
    @JoinColumn(name = "author_id")
    @Setter
    private User author;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    @Setter
    private Offer offer;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    @Setter
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "reply_id")
    @Setter
    private Reply answer;

    @ManyToMany
    @JoinTable(name = "tb_topic_likes",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> likes = new HashSet<>();

    @OneToMany(mappedBy = "topic")
    private List<Reply> replies = new ArrayList<>();

    public Topic(Long id, String title, String body, Instant moment, User author, Offer offer, Lesson lesson, Reply answer) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.moment = moment;
        this.author = author;
        this.offer = offer;
        this.lesson = lesson;
        this.answer = answer;
    }
}
