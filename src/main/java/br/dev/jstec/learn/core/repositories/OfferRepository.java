package br.dev.jstec.learn.core.repositories;

import br.dev.jstec.learn.core.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
