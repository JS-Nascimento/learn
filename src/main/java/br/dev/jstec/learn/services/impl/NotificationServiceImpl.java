package br.dev.jstec.learn.services.impl;

import br.dev.jstec.learn.core.model.Notification;
import br.dev.jstec.learn.core.model.User;
import br.dev.jstec.learn.core.repositories.NotificationRepository;
import br.dev.jstec.learn.resources.dto.NotificationDTO;
import br.dev.jstec.learn.services.AuthService;
import br.dev.jstec.learn.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository repository;
    @Autowired
    private AuthService authService;
    @Override
    public Page<NotificationDTO> notificationForCurrentUser(Pageable pageable){
        User user = authService.authenticated();
        Page<Notification> page = repository.findByUser(user,pageable);
        return page.map(notification -> new NotificationDTO(notification.getId(),notification.getText()
                                                                ,notification.getMoment(), notification.isRead()
                                                                ,notification.getRoute(), notification.getUser().getId()));

    }
}
