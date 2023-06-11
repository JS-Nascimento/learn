package br.dev.jstec.learn.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_section")
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;
    @Setter
    private String title;
    @Setter
    private String description;
    @Setter
    private Integer position;
    @Setter
    private String imgUri;
    @Setter
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
    @Setter
    @ManyToOne
    @JoinColumn(name = "prerequisite_id")
    private Section prerequisite;

    @OneToMany(mappedBy = "section")
    private List<Lesson> lessons;

    public Section(Long id, String title, String description, Integer position, String imgUri, Resource resource, Section prerequisite) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.position = position;
        this.imgUri = imgUri;
        this.resource = resource;
        this.prerequisite = prerequisite;
    }
}
