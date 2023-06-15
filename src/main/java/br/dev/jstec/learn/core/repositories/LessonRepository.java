package br.dev.jstec.learn.core.repositories;

import br.dev.jstec.learn.core.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
