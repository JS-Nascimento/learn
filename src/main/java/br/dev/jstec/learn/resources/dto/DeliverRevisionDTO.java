package br.dev.jstec.learn.resources.dto;

import br.dev.jstec.learn.core.enums.DeliverStatus;

public record DeliverRevisionDTO(DeliverStatus status, String feedback, Integer correctCount) {
}
