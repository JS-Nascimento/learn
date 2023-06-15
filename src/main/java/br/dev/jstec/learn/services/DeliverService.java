package br.dev.jstec.learn.services;

import br.dev.jstec.learn.resources.dto.DeliverRevisionDTO;

public interface DeliverService {
    void saveRevision(Long id, DeliverRevisionDTO dto);
}
