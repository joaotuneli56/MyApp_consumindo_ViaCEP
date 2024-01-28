package br.com.viaCep.exception;

public class ErrorException extends RuntimeException{
    private String mensagem;

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
