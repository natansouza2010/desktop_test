# Projeto: Teste técnico 

## Tecnologias

* **Java 11**
* **Spring Boot**
* **Javascript ES6**
* **React.js **
* **ES6 Modules**
* **PostgressSQL (Container)**
* **API REST**
* **Docker**
* **docker-compose**
* **Axios**


## Arquitetura Proposta

O sistema é monolito.

Também o banco está rodando em containers docker via docker-compose.


## Logs e Tracing da API 

baseURL: https://localhost:8085


Book Request POST ( api/books/save )
```

{
	"title": "Pessoas normais",
	"author": "Sally Rooney",
	"categoryId": "b040c1e4-aef3-4568-8b7d-76bcf83ea8d0"
	
}


```

Book Response POST (api/books/save) 
```

{
	"title": "Pessoas normais",
	"author": "Sally Rooney",
	"categoryId": "b040c1e4-aef3-4568-8b7d-76bcf83ea8d0"
	
}


```

Book Response GET (/api/books) 
```

[
	{
		"id": "24a47b15-d2e8-4e83-866e-905daf766e9c",
		"title": "Pessoas normais",
		"author": "Sally Rooney",
		"categoryName": "Romance"
	},
	{
		"id": "a21bf0a9-b53d-46fc-b286-a9e8343e03db",
		"title": "Fim",
		"author": "Fernanda Torres",
		"categoryName": "Romance"
	},
	{
		"id": "2ee78dff-bccc-4d3a-94ec-03aa42ed0a16",
		"title": "Tudo ´e Rio",
		"author": "Carla Madeira",
		"categoryName": "Romance"
	},
	{
		"id": "14ec500a-75ab-4191-9f79-d4cf4ab3f56a",
		"title": "Quinze Dias",
		"author": "Victor Martins",
		"categoryName": "Romance"
	},
]

```


Book Response DELETE (api/books/:id)
```
{
	"status": 200,
	"message": "O livro foi deletado"
}

```

Book Request PUT (api/books/:id)

```
{
	"title": "Branca de Neve",
	"author": "Gilberto",
	"categoryId": "b040c1e4-aef3-4568-8b7d-76bcf83ea8d0"
	
}

```

Category ENDPOINST 
```
GET - /api/categories
PUT - /api/categories/:id
DELETE - /api/categories/:id
POST - /api/categories/save

```


### Execução docker-compose

`docker-compose up --build`

### Executar create.sql 

`Dados populados no arquivo create.sql`

### Execução FRONT 

Package ..desktop_test/front/desktop_test_front/

`npm install`
`npm run dev`

#Requisitos Atendidos 

Back-End : 
```
  Criar tabelas no banco de dados para armazenar informações sobre livros e categorias.             [x]
  Garantir que o código do livro seja único.            [x]
  Relacionar a tabela de livros com a tabela de categorias.      [x]
  Implementar endpoints para listar, criar, atualizar e excluir categorias de livros.           [x]
  Implementar endpoints para listar, criar, atualizar e excluir livros.   [x]
  Validar os dados de entrada para garantir consistência e integridade.    [x]
  Utilizar um banco de dados relacional (como MySQL) para armazenar os dados de livros e categorias.  [x]
  Implementar as consultas SQL necessárias para interagir com o banco de dados de forma eficiente.    [x]
```

Front-End: 
```
  Integrar o frontend com os endpoints da API para buscar e enviar dados para o backend.       [x]
  Utilizar HTML/CSS para criar um layout responsivo e atraente para o painel administrativo.   [x]
  Implementar painel de listar, criar, atualizar e excluir livros.                              [/]  Faltou realizar o painel de atualizar livro
  Implementar painel de criar categorias de livros.                                             [x]
```
