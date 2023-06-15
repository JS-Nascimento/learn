package br.dev.jstec.learn.services.exceptions;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message){
        super(message);
    }
}
