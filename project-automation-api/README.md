# 📚 Projeto de Automação — API DemoQA BookStore

Automação desenvolvida em **Java + RestAssured + JUnit + Cucumber**, seguindo boas práticas de BDD e organização de código.  
Este projeto implementa o fluxo completo exigido no desafio técnico, consumindo as APIs públicas da DemoQA Bookstore.

---

## 🚀 Fluxo Automatizado

O teste executa automaticamente:

1. **Criar um usuário**  
   `POST /Account/v1/User`

2. **Gerar token de acesso**  
   `POST /Account/v1/GenerateToken`

3. **Validar se o usuário está autorizado**  
   `POST /Account/v1/Authorized`

4. **Listar os livros disponíveis**  
   `GET /BookStore/v1/Books`

5. **Alugar dois livros**  
   `POST /BookStore/v1/Books`

6. **Validar que o usuário contém os livros alugados**  
   `GET /Account/v1/User/{userId}`

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Maven**
- **RestAssured**
- **JUnit**
- **Cucumber (BDD)**
- **JSONPath**
- **IntelliJ IDEA**

---
