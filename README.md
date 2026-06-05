# workshop-mongodb

API REST de estudo usando Spring Boot + MongoDB, com usuarios, posts e comentarios.

## Stack

- Java 25
- Spring Boot 4.0.6
- Spring WebMVC
- Spring Data MongoDB
- Lombok
- Springdoc OpenAPI

## Requisitos

- Java 25
- Maven 3.9+
- MongoDB 6+

## Configuracao

Arquivo: `src/main/resources/application.yaml`

```yaml
server:
  port: 8080

spring:
  application:
    name: workshop-mongodb

  mongodb:
    host: localhost
    port: 27017
    database: workshop-mongodb
```

## Como rodar

1) Suba o MongoDB localmente.
2) Rode a aplicacao:

```bash
mvn spring-boot:run
```

Base URL: `http://localhost:8080`

## Endpoints

Usuarios

- `GET /v1/usuario`
- `GET /v1/usuario/{id}`
- `POST /v1/usuario`
- `PUT /v1/usuario/{id}`
- `DELETE /v1/usuario/{id}`
- `GET /v1/usuario/{id}/posts`

Posts

- `GET /v1/post`
- `GET /v1/post/{id}`
- `POST /v1/post`
- `PUT /v1/post/{id}`
- `DELETE /v1/post/{id}`
- `POST /v1/post/{id}/comentarios`

## Exemplos de request

Criar usuario

```json
{
  "nome": "Maria Silva",
  "email": "maria@email.com"
}
```

Criar post

```json
{
  "titulo": "Meu primeiro post",
  "descricao": "Conteudo do post",
  "autorId": "<usuarioId>"
}
```

Atualizar post

```json
{
  "titulo": "Novo titulo",
  "descricao": "Nova descricao"
}
```

Adicionar comentario

```json
{
  "texto": "Muito bom!",
  "autorId": "<usuarioId>"
}
```

## Estrutura de dados (resumo)

- Usuario possui lista de posts (DBRef)
- Post possui autor (dados do usuario) e lista de comentarios
- Comentario possui texto, data e autor (id/nome)

## OpenAPI / Swagger

- UI: `http://localhost:8080/swagger-ui/index.html`
- JSON: `http://localhost:8080/v3/api-docs`

## Testes

```bash
mvn test
```
