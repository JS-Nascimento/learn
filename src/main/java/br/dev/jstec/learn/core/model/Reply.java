package br.dev.jstec.learn.core.model;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_reply")
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Column(columnDefinition = "TEXT")
    @Setter
    private String body;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Setter
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @Setter
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @Setter
    private User author;

    @ManyToMany
    @JoinTable(name = "tb_reply_likes",
            joinColumns = @JoinColumn(name = "reply_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> likes = new HashSet<>();

    public Reply(Long id, String body, Instant moment, Topic topic, User author) {
        this.id = id;
        this.body = body;
        this.moment = moment;
        this.topic = topic;
        this.author = author;
    }
}