package br.com.meta.desafio.worldbank.service.exceptions;

public class PageNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PageNotFoundException(String message) {
        super(message);

    }
}
