package br.dev.jstec.learn.resources.controllers;

import br.dev.jstec.learn.resources.dto.NotificationDTO;
import br.dev.jstec.learn.resources.dto.UserDTO;
import br.dev.jstec.learn.services.NotificationService;
import br.dev.jstec.learn.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationController {
    private NotificationService service;
    public NotificationController(NotificationService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> notificationForCurrentUser(Pageable pageable) {
        Page<NotificationDTO> page = service.notificationForCurrentUser(pageable);
        return ResponseEntity.ok(page);
    }
}
