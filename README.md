# 🎮 API de Catálogo de Jogos

Uma API RESTful desenvolvida em Java/Spring Boot para gerenciar um catálogo de jogos e clientes,
desenvolvida como trabalho acadêmico para a matéria de Back-End.  
Professora: **Ingrid Avila**  
[![LinkedIn](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=YOUR_LINKEDIN_URL)](https://www.linkedin.com/in/ingrid-avila-0ba7a420a/)

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.5**
- **Spring Data JPA**
- **H2 Database** (banco em memória)
- **Maven**
- **Lombok**
- **Validation**
- **Postman** (para testes)  


## 🎯 Funcionalidades
### 📊 Entidade Jogo
- ✅ CRUD completo
- ✅ Busca por ID
- ✅ Listagem geral
- ✅ Validações de campos

### 👥 Entidade Cliente
- ✅ CRUD completo
- ✅ Busca por ID
- ✅ Listagem geral
- ✅ Validações de campos

### 🔧 Endpoints Disponíveis

#### Jogos (`/jogo`)
- `GET /jogo` - Lista todos os jogos
- `GET /jogo/{id}` - Busca jogo por ID
- `POST /jogo` - Cria novo jogo
- `PATCH /jogo/{id}` - Atualiza jogo parcialmente
- `DELETE /jogo/{id}` - Remove jogo

#### Clientes (`/cliente`)
- `GET /cliente` - Lista todos os clientes
- `GET /cliente/{id}` - Busca cliente por ID
- `POST /cliente` - Cria novo cliente
- `PATCH /cliente/{id}` - Atualiza cliente parcialmente
- `DELETE /cliente/{id}` - Remove cliente  


## 🛠️ Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.6+
- Postman (para testes)

### 🚀 Execução
```bash
# Clone o repositório
git clone <url-do-repositorio>

# Entre no diretório
cd jogo-api

# Execute com Maven
mvn spring-boot:run

# Ou execute pela IDE
# A aplicação estará disponível em http://localhost:8080
```  

## 🧪 Testando com Postman
Exemplo de JSON para Criar Jogo:
``` bash
{
  "titulo": "The Legend of Zelda",
  "genero": "Aventura",
  "plataforma": "Nintendo Switch",
  "anoLancamento": 2017,
  "descricao": "Jogo de aventura épico",
  "preco": 299.90
}
```
Exemplo de JSON para Criar Cliente:
```bash  
{
  "nome": "Daniel Silva",
  "email": "daniel@email.com",
  "cpf": "12345678907",
  "telefone": "21999999999"
}  
```  

## 📊 Banco de Dados H2
O projeto utiliza banco H2 em memória:

Console H2: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:jogos

Usuário: sa

Senha: (vazia)

## 🔮 Próximas Melhorias Possíveis
Autenticação e autorização (Spring Security)

Documentação com Swagger/OpenAPI

Testes unitários e de integração

Deploy em nuvem (Heroku, AWS)

Front-end para consumir a API  

## 👨‍💻 Desenvolvedor
[Daniel de S. Silva] - Trabalho acadêmico para matéria de Back-End

## 📝 Licença
Este projeto foi desenvolvido para fins acadêmicos.
