package br.com.conectaporto.validadorcep.services.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    /**
     * Cria e configura um bean de {@link WebClient} para ser usado em toda a aplicação.
     * A URL base padrão é definida para o serviço BrasilAberto, que é utilizado para consultas de CEP.
     *
     * @return uma instância configurada de {@link WebClient}.
     */
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://brasilaberto.com/")
                .build();
    }
}
