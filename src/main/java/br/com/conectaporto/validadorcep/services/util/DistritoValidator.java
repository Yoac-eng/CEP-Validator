package br.com.conectaporto.validadorcep.services.util;


import java.util.Set;
import java.util.stream.Collectors;

public class DistritoValidator {

    private DistritoValidator() {
    }

    private static final Set<String> DISTRICTS = Set.of(
            "Alto da Vitória", "Anjo da Guarda", "Fumacê", "Gancharia", "Itaqui", "Vila Verde",
            "Alto da Esperança", "Mauro Fecury I", "Mauro Fecury II", "Residencial Ana Jansen",
            "São Raimundo", "Tamancão", "Vila Ariri", "Vila Nova", "Vila São Luís", "Vila São Mateus",
            "Jambeiro", "Sa Viana", "Vila Bacanga", "Vila Cerâmica", "Vila Dom Luís", "Vila Isabel",
            "Vila Real", "América do Norte", "Argola e Tambor", "Cidade Nova", "Gapara",
            "Residencial Paraíso", "Residencial Primavera", "Residencial Resende", "São Benedito",
            "Vila da Paz", "Vila Embratel I", "Vila Embratel II", "Vila São João",
            "Vila São João da Boa Vista", "Vila Zagueiro", "Vila Maranhão", "Taim",
            "Rio dos Cachorros", "Cajueiro", "Porto Grande", "Vila Conceição", "Vila São Benedito",
            "Limoeiro", "Parnuaçu", "Jardim São Joaquim", "Vila Tiradentes"
    ).stream()
    .map(String::toLowerCase)
    .collect(Collectors.toSet());

    /**
     * Valida a String do distrito/bairro e verifica se a mesma está na área de Itaqui-Bacanga.
     *
     * @param district O distrito/bairro a ser validado.
     * @return boolean
     */
    public static boolean isValid(String district) {
        return DISTRICTS.contains(district.toLowerCase());
    }
}
