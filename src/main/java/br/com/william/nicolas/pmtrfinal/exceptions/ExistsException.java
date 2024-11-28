package br.com.william.nicolas.pmtrfinal.exceptions;

public class ExistsException extends RuntimeException{
    public ExistsException() {
        super("It already exists");
    }
}
