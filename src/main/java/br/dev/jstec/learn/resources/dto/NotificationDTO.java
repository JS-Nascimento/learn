package br.dev.jstec.learn.resources.dto;
import br.dev.jstec.learn.core.model.Notification;
import br.dev.jstec.learn.core.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
public record NotificationDTO(Long id, String text, Instant moment, boolean read, String route, Long user_id) {

}
