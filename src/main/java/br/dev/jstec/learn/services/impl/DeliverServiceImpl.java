package br.dev.jstec.learn.services.impl;

import br.dev.jstec.learn.core.model.Deliver;
import br.dev.jstec.learn.core.repositories.DeliverRepository;
import br.dev.jstec.learn.resources.dto.DeliverRevisionDTO;
import br.dev.jstec.learn.services.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliverServiceImpl implements DeliverService {
    @Autowired
    private DeliverRepository repository;
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    public void saveRevision(Long id, DeliverRevisionDTO dto){
        Deliver deliver = repository.getReferenceById(id);
        deliver.setStatus(dto.status());
        deliver.setFeedback(dto.feedback());
        deliver.setCorrectCount(dto.correctCount());
        repository.save(deliver);
    }
}
