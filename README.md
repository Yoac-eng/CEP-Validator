# API de Validação de CEPs

## Descrição
- Este projeto é uma API desenvolvida com Spring WebFlux para validar CEPs e verificar se pertencem à área de Itaqui-Bacanga. Ele utiliza o WebClient para realizar chamadas a APIs externas de CEP e valida se o distrito retornado está dentro de uma lista predefinida de distritos válidos.
Este serviço utiliza o serviço de obtenção de informações de um CEP do BrasilAberto.

## Tecnologias

- Java 
- Spring Boot
- Spring WebFlux
- Maven

## Configuração e Instalação
- Como configurar e instalar a aplicação:

### Pré requisitos
- JDK 11 ou +
- Maven

### Instalação

1. Clone o repositório:
```
git clone https://github.com/Yoac-eng/CEP-Validator.git
```
2. No diretório do projeto, execute:
```
 mvn clean install
```
3. Basta rodar a aplicação.

## Uso
Exemplo de como utilizar a API para validar um CEP:
### Requisição
```
GET /cep/{cep}
```
Valida se o CEP fornecido pertence à área do Itaqui-Bacanga e retorna informações sobre a validade do distrito/bairro associado a esse CEP.
- Parâmetros de URL: O **CEP(obrigatório)** a ser validado, no formato 'NNNNN-NNN' ou 'NNNNNNNN'.
### Respostas
- 200 OK:
  - O CEP é válido e pertence à área do Itaqui-Bacanga. 
```
// http://localhost:8080/cep/65080-660
{
	"isDistrictValid": true,
	"message": "O distrito se encontra na área do Itaqui-Bacanga."
}
```
- 400 Bad Request:
  - O formato do CEP fornecido é inválido. 
```
// http://localhost:8080/cep/65010-9
{
	"isDistrictValid": false,
	"message": "CEP inválido, por favor verifique o formato do mesmo."
}
```
- 200 OK:
  - O CEP é válido, mas não pertence à área de Itaqui-Bacanga.
```
// http://localhost:8080/cep/65010-904
{
  "isDistrictValid": false,
  "message": "Distrito fora da área Itaqui-Bacanga."
}
```
- 400 Bad Request:
  - O formato do CEP fornecido é válido porém o CEP não existe ou está inativo.
```
// http://localhost:8080/cep/65010-123
{
	"isDistrictValid": false,
	"message": "CEP inválido, este CEP não existe."
}
```
