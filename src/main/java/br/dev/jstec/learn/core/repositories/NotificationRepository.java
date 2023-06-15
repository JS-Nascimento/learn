package br.dev.jstec.learn.core.repositories;

import br.dev.jstec.learn.core.model.Notification;
import br.dev.jstec.learn.core.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Page<Notification> findByUser(User user, Pageable pageable);
}
