package br.dev.jstec.learn.services;

import br.dev.jstec.learn.core.model.User;

public interface AuthService {
    User authenticated();
    void validateSelfOrAdmin(Long userId);
}
