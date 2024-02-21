package br.com.conectaporto.validadorcep.services.exceptions;


/**
 * Exception utilizada para casos quando o cep informado não está no formado esperado
 * e/ou não existem.
 */
public class CepInvalidoException extends RuntimeException{

    public CepInvalidoException(String msg) {
        super(msg);
    }
}
