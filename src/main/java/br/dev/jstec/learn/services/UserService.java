package br.dev.jstec.learn.services;

import br.dev.jstec.learn.resources.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    UserDTO findById(Long id);
}
