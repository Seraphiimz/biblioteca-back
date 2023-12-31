package serapku.com.bibliotecaback.service;

public class AutorInvalidaException extends RuntimeException{
    public AutorInvalidaException(String mensagem){
        super(mensagem);
    }
}
