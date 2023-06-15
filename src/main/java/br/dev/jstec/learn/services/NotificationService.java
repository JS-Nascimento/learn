package br.dev.jstec.learn.services;

import br.dev.jstec.learn.resources.dto.NotificationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificationService {
    Page<NotificationDTO> notificationForCurrentUser(Pageable pageable);
}
