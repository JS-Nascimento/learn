package br.dev.jstec.learn.services.exceptions;

public class DatabaseIntegrityException extends RuntimeException {
    public DatabaseIntegrityException ( String message){
        super(message);
    }
}
