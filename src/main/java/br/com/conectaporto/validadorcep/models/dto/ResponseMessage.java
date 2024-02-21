package br.com.conectaporto.validadorcep.models.dto;


/**
 * Classe que representa como o serviço de validação de CEP retorna a resposta
 * da requisição.
 */
public class ResponseMessage {

    public Boolean isDistrictValid;
    public String message;

    public ResponseMessage(Boolean isDistrictValid, String message) {
        this.isDistrictValid = isDistrictValid;
        this.message = message;
    }

    public Boolean getIsDistrictValid() {
        return isDistrictValid;
    }

    public void setIsDistrictValid(Boolean isDistrictValid) {
        this.isDistrictValid = isDistrictValid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
