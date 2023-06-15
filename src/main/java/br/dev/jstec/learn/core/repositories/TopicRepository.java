package br.dev.jstec.learn.core.repositories;

import br.dev.jstec.learn.core.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
