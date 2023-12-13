#  Documentação da api

## configuração do banco de dados

```
spring.datasource.url= jdbc:mysql://localhost:3306/coloque-o-nome-de-uma-base-de-dados-mysql
spring.datasource.username=root
spring.datasource.password=coloque-a-senha-do-seu-mysql

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true
```

## Rotas principais para request :

### POST

* POST : http://localhost:8080/blog
  
#### corpo do post 

```javascript
{
    'nome' : 'nome do livro',
    'comentario' : 'review do livro' ,
    'url': 'url da imagem do livro' 
    'data' : 'data da postagem',
    'hoursdate' : 'horário em que a postagem foi'
}
```

### GET-ALL

* GET : http://localhost:8080/blog

### GET-BY-NAME 

* GETByName : http://localhost:8080/blog/nome-da-postagem
