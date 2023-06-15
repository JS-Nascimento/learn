package br.dev.jstec.learn.core.repositories;

import br.dev.jstec.learn.core.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
