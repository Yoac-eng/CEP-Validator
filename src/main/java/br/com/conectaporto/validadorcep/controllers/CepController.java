package br.com.conectaporto.validadorcep.controllers;


import br.com.conectaporto.validadorcep.models.dto.ResponseMessage;
import br.com.conectaporto.validadorcep.services.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/cep")
public class CepController {

    @Autowired
    private CepService service;

    /**
     * Valida se o CEP fornecido está dentro da área do Itaqui-Bacanga.
     * Retorna uma resposta HTTP contendo uma mensagem indicativa do resultado da validação.
     *
     * @param cep O CEP a ser validado, passado como parte do caminho da URL.
     * @return Um {@link Mono<ResponseEntity<ResponseMessage>>} contendo o resultado da validação.
     *         Retorna um status OK (200) com uma mensagem de sucesso se o CEP for válido,
     *         com a confirmação de inclusão ou não na área do Itaqui-Bacanga no corpo da resposta.
     *         Caso o CEP não seja válido ou tenha algum outro erro, um status adequado é retornado.
     */
    @GetMapping(value = "/{cep}")
    public Mono<ResponseEntity<ResponseMessage>> validateCEP(@PathVariable String cep) {
        return service.validate(cep)
                .map(distrito -> ResponseEntity.ok().body(new ResponseMessage(true, "O distrito se encontra na área do Itaqui-Bacanga.")));
    }
}
