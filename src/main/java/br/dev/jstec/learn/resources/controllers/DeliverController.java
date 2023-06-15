package br.dev.jstec.learn.resources.controllers;

import br.dev.jstec.learn.resources.dto.DeliverRevisionDTO;
import br.dev.jstec.learn.services.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverController {

    @Autowired
    private DeliverService service;
    @PutMapping(value = "{id}")
    public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody DeliverRevisionDTO deliverRevisionDTO){
        service.saveRevision(id, deliverRevisionDTO);
        return ResponseEntity.noContent().build();
    }

}
