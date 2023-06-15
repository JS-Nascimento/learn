package br.dev.jstec.learn.core.repositories;

import br.dev.jstec.learn.core.model.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliverRepository extends JpaRepository<Deliver, Long> {
}
