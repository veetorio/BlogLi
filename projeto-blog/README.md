#  Documentação da api

## configuração do banco de dados

caso queira testar na sua maquina, vá até a pasta de resources que está nesta rota Projeto-blog/back-end/liblog/src/main/resources

ao clickar nela você irá ver um arquivo chamado "application.properties" nela você vai ter acesso a essa configuração, se caso a spring.profile.active esteja com APP_PROFILE:myHost ou ceuma, mude para h2connection
igual ao que está abaixo
```
spring.profiles.active=${APP_PROFILE:h2connection}
spring.jpa.open-in-view=false
```

## Rotas principais para request de Post:

### POST

* POST : http://localhost:8080/blog
  
#### corpo do post 

```json
{
 
    "nome" : "nome do livro1",
    "comentario" : "review do livro1" ,
    "url": "url da imagem do livro",
    "data" : "2023-04-01",
    "hoursdate" : "23:23:01",
    "user" : {"id": 1 }
}
```

### GET-ALL

* GET : http://localhost:8080/blog

### GET-BY-NAME 

* GETByName : http://localhost:8080/blog/nome-da-postagem

### DELETE

* DELETE : http://localhost:8080/blog/nome-da-postagem-que-deseja-apagar

### PUT : 
 ```json
    "id" : "id-do-usuario",
    "nome" : "nome do livro1",
    "comentario" : "review do livro1" ,
    "url": "url da imagem do livro",
    "data" : "2023-04-01",
    "hoursdate" : "23:23:01",
    "user" : {"id": 1 }

```


## Rotas principais para request de Usuario:

### POST

* POST : http://localhost:8080/usuarios
  
#### corpo do post 

```json
{
         "nome_usuario": "Usuaro",
         "email": "usuario1@examcom",
         "senha_usuario": "udskddk"
}
```

### GET-ALL

* GET : http://localhost:8080/usuarios

### GET-BY-NAME 

* GETByName : http://localhost:8080/usuarios/nome-do-usuario

### DELETE

* DELETE : http://localhost:8080/usuarios/nome-da-postagem-que-deseja-apagar

### PUT 
* corpo do put
```
{
         "id" : 1,
         "nome_usuario": "Usuao",
         "email": "usuario1@examcom",
         "senha_usuario": "udskddk"
}
```
  ### Autenticação

  * Auth : http://localhost:8080/authUser
  * method : Post
 
##corpo da autenticação
```json
{
    "dataSearchName" : "nome-ou-usuario",
    "dataSearchPassword" : "senha123"
}
```
  




