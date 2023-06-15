package br.dev.jstec.learn.services.impl;

import br.dev.jstec.learn.core.model.User;
import br.dev.jstec.learn.core.repositories.UserRepository;
import br.dev.jstec.learn.services.AuthService;
import br.dev.jstec.learn.services.UserService;
import br.dev.jstec.learn.services.exceptions.ForbiddenException;
import br.dev.jstec.learn.services.exceptions.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AuthServiceImpl implements AuthService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository repository;
    public AuthServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            logger.info(SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
            return repository.findByEmail(username);
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid user.");
        }
    }
    public void validateSelfOrAdmin(Long userId){
        User user = authenticated();
        if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denied!!");
        }
    }
}
