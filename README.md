# API de Produtos com Spring Boot e JWT

Uma API RESTful para gerenciar produtos, com autenticação baseada em JWT e persistência em banco H2.  
O projeto foi desenvolvido como estudo e portfólio de back-end.

---

## 🚀 Tecnologias

- Java 23
- Spring Boot 3
- Spring Data JPA
- Spring Security + JWT
- H2 Database (memória)
- Lombok
- Maven
- Postman para testes
- Bootstrap (front-end mínimo, se houver)

---

## 🛠️ Funcionalidades

### Usuário
- Cadastro: `/auth/cadastrar`
- Login: `/auth/login` → retorna JWT

### Produto
- Listar todos: `GET /produtos` (público)
- Buscar por nome: `GET /produtos/{nome}` (público)
- Criar produto: `POST /produtos` (necessário token)
- Atualizar produto: `PUT /produtos/{id}` (necessário token)
- Deletar produto: `DELETE /produtos/{id}` (necessário token)

---

## 🔑 Autenticação

- JWT é usado para proteger endpoints.
- Token deve ser enviado no **header**:


---

## 📌 Observações

Senhas são armazenadas criptografadas com BCrypt.

A API está configurada para stateless (sem sessão).

JWT expira em ~24h (ajustável em JwtTokenService).

---

## 👨‍💻 Autor

Lucas Xavier – LinkedIn
– GitHub
