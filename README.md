# Primeiros passos para criar o projeto

Este projeto foi criado com [Create React App](https://github.com/facebook/create-react-app).
Este projeto foi criado com [Starter project](https://github.com/spring-projects/spring-boot).

# Documentação da API

Link abaixo para documentação da api no Swagger (Open api)
[https://desafio-softplayer.herokuapp.com/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config] 

## Scripts disponiveis

Dentro da pasta frontend, você pode rodar:


### `yarn start`

Executa o aplicativo no modo desenvolvimento.\
Abra [http://localhost:3000](http://localhost:3000) para visualizar no browser.

A página será recarregada se você fizer edições.\
Você também irá se deparar com qualquer erro de lint no console.

## Backend

- Deve subir o docker para rodar o mysql
- O spring está rodando na porta 8080
- Precisa cadastrar um usuário, pois estou utilizando OAUTH 2


### Deployment

O deploy é automático, pois a minha branch do github está integrada com o heroku e vercel

### Testes

- Teste de API com a controller
- Teste de integração com a service de people
- Teste unitário de repositório
- Teste de integração

### Tecnologias usadas
- Java
- Swagger
- Spring boot
- Docker
- React Js
- Mysql
- Mapstruct para mapear os atributos json [https://mapstruct.org/]
- Heroku cloud para hospedar a api [https://desafio-softplayer.herokuapp.com/]
- Vercel cloud para hospedar o frontend [https://desafio-softplan-web.vercel.app/]
- CI com o próprio github [https://github.com/DieguinhoHR/desafio-softplan]
- Testes unitários com JUnit

### Aplicado

- A aplicação rodando em algum ambiente em nuvem.
- Teste de integração da API em linguagem de sua preferência (Damos importância para pirâmide de testes)
- A API desenvolvida em REST, seguindo o modelo de maturidade de Richardson ou utilizando GraphQL.
- A API deverá conter documentação executável que poderá ser utilizada durante seu desenvolvimento. (Utilizar  swagger)
- Integração com OAuth 2 Google (https://developers.google.com/identity/protocols/OAuth2)