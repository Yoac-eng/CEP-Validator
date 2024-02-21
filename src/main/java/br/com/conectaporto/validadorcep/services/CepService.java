package br.com.conectaporto.validadorcep.services;

import br.com.conectaporto.validadorcep.models.dto.BrasilAbertoApiResponse;
import br.com.conectaporto.validadorcep.services.exceptions.CepForaDeAreaException;
import br.com.conectaporto.validadorcep.services.exceptions.CepInvalidoException;
import br.com.conectaporto.validadorcep.services.util.DistritoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CepService {

    // WebClient do WebFlux para se comunicar com API externa.
    private final WebClient webClient;

    @Autowired
    public CepService(WebClient webClient) {
        this.webClient = webClient;
    }


    /**
     * Valida o formato do CEP e verifica se o distrito correspondente está na área de Itaqui-Bacanga.
     *
     * @param cep O CEP a ser validado.
     * @return {@link Mono<String>} com o nome do distrito ou um erro se o CEP for inválido ou fora da área.
     */
    public Mono<String> validate(String cep) {
        String cepRegex = "^\\d{5}-\\d{3}$";

        if (!cep.matches(cepRegex)) {
            return Mono.error(new CepInvalidoException("CEP inválido, por favor verifique o formato do mesmo."));
        }
        return obterDistritoPorCep(cep)
                .flatMap(distrito -> {
                    if (DistritoValidator.isValid(distrito)) {
                        return Mono.just(distrito);
                    }
                    else {
                        return Mono.error(new CepForaDeAreaException("Distrito fora da área Itaqui-Bacanga."));
                    }
                });
    }

    /**
     * Obtém o nome do distrito associado a um CEP.
     * Faz uma chamada à API de CEP e extrai o nome do distrito da resposta.
     * O serviço/API utilizado é o do BrasilAberto.
     *
     * @param cep O CEP cujo distrito/bairro é para ser obtido.
     * @return {@link Mono<String>} com o nome do distrito/bairro ou um erro se o CEP for inválido ou não existir.
     */
    public Mono<String> obterDistritoPorCep(String cep) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/v1/zipcode/{cep}")
                        .build(cep))
                .exchangeToMono(response -> {
                   if(response.statusCode().equals(HttpStatus.OK)){
                       return response.bodyToMono(BrasilAbertoApiResponse.class)
                               .map(brasilAbertoApiResponse -> brasilAbertoApiResponse.getResult().getDistrict());
                   }else{
                       return Mono.error(new CepInvalidoException("CEP inválido, este CEP não existe."));
                   }
                });
    }
}
