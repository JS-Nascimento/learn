package br.dev.jstec.learn.core.repositories;

import br.dev.jstec.learn.core.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
