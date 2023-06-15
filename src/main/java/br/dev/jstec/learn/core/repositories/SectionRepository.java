package br.dev.jstec.learn.core.repositories;

import br.dev.jstec.learn.core.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
