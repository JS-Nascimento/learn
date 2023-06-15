package br.dev.jstec.learn.services.impl;

import br.dev.jstec.learn.core.repositories.RoleRepository;
import br.dev.jstec.learn.core.repositories.UserRepository;
import br.dev.jstec.learn.resources.dto.UserDTO;
import br.dev.jstec.learn.services.AuthService;
import br.dev.jstec.learn.services.UserService;
import br.dev.jstec.learn.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository repository;
    private final AuthService authService;
    public UserServiceImpl(UserRepository repository, AuthService authService) {
        this.repository = repository;
        this.authService = authService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = repository.findByEmail(username);
        if (userDetails == null) {
            logger.error("User not found: " + username);
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }
        logger.info("User found : " + username);
        return userDetails;
    }
    @Override
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        authService.validateSelfOrAdmin(id);
        return repository.findById(id)
                .map(User -> (new UserDTO(User)))
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não existe."));
    }

}
