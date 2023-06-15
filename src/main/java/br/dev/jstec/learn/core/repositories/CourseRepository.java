package br.dev.jstec.learn.core.repositories;

import br.dev.jstec.learn.core.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
