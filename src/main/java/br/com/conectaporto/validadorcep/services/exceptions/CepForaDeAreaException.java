package br.com.conectaporto.validadorcep.services.exceptions;


/**
 * Exception utilizada para casos quando o cep informado é válido porém não
 * se encaixa na área pertencente à área Itaqui-Bacanga.
 */
public class CepForaDeAreaException extends RuntimeException{

    public CepForaDeAreaException(String msg) {
        super(msg);
    }
}
