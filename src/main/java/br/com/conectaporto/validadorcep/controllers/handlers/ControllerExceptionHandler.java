package br.com.conectaporto.validadorcep.controllers.handlers;


import br.com.conectaporto.validadorcep.models.dto.ResponseMessage;
import br.com.conectaporto.validadorcep.services.exceptions.CepForaDeAreaException;
import br.com.conectaporto.validadorcep.services.exceptions.CepInvalidoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * Classe com objetivo de centralizar e customizar o manuseio das exceções
 * lançadas pela aplicação.
 * Essa classe retorna respostas com seus respectivos HTTP Status Code.
 */
@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CepForaDeAreaException.class)
    public ResponseEntity<ResponseMessage> outOfAreaCEP(CepForaDeAreaException e, HttpServletRequest request) {
        return ResponseEntity.ok().body(new ResponseMessage(false, e.getMessage()));
    }
    @ExceptionHandler(CepInvalidoException.class)
    public ResponseEntity<ResponseMessage> invalidCEP(CepInvalidoException e, HttpServletRequest request) {
        return ResponseEntity.badRequest().body(new ResponseMessage(false, e.getMessage()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> handleAllExceptions(Exception e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage(false, "Erro interno do servidor"));
    }

}
