# Estoque de Produtos

Esse projeto tem como objetivo gerenciar um estoque de produtos.


## Documentação da API

#### Retorna todos os produtos

```http
  GET /api/produtos
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `N/A` | `N/A` | Retorna uma lista com todos os produtos cadastrados |

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
| `id*`      | `Integer` | Retorna um produto desejado por `id`  |

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
| `N/A`      | `N/A` | Cria um produto do tipo `Produto` |

```
Response - 201
```

```
RequestBody
{
    "id": Integer,
    "name": String,
    "quantidade": Integer,
    "valor": Double,
    "descricao": String
}
```

#### Delete um produto

```http
  DELETE /api/produtos/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id* `      | `Integer` | Deleta um item do tipo `Produto` passando o `id` do item desejado |

```
Response - 200
```

#### Atualizar um produto

```http
  PUT /api/produtos/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id*`      | `Integer` | Atualiza um item do tipo `Produto` passando o `id` do item desejado e alterando qualquer atributo do objeto. Caso o id não exista é criado um novo produto |

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
    "id": Integer,
    "name": String,
    "quantidade": Integer,
    "valor": Double,
    "descricao": String
}
```
