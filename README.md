# Estoque de Produtos

Esse projeto tem como objetivo gerenciar um estoque de produtos.


## Documentação da API

#### Retorna todos os produtos

```http
  GET /api/produtos
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `NULL` | `List<Produtos>` | Retorna uma lista com todos os produtos cadastrados |

```
Response - 200
[
    {
        "id": Integer,
        "name": String,
        "quantidade": Integer,
        "valor": Double,
        "descricao": String
    }
]
```
#### Retorna um produto

```http
  GET /api/produtos/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Produto` | Retorna um produto por `id` do produto desejado  |

```
Response - 200
{
    "id": Integer,
    "name": String,
    "quantidade": Integer,
    "valor": Double,
    "descricao": String
}
```
#### Cria um produto

```http
  POST /api/produtos
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `NULL`      | `Void` | Cria um produto do tipo `Produto` |

```
Response - 201
```

```
RequestBody
{
    "name": String,
    "quantidade": Integer,
    "valor": Double,
    "descricao": String
}
```

#### Delete um produto

```http
  DELETE /api/produtos
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Void` | Deleta um item do tipo `Produto` passando o `id` do item desejado |

```
Response - 200
```

#### Atualizar um produto

```http
  PUT /api/produtos
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Void` | Atualiza um item do tipo `Produto` passando o `id` do item desejado e alterando qualquer atributo do objeto. Caso o id não exista é criado um novo produto |

Váriavel - Opcional
```
Response - 200
{
    "name": String,
    "quantidade": Integer,
    "valor": Double,
    "descricao": String
}
```
```
RequestBody
{
    "name": String,
    "quantidade": Integer,
    "valor": Double,
    "descricao": String
}
```
## Rodando os testes

Para rodar os testes, rode o seguinte comando

```bash
  npm run test
```

