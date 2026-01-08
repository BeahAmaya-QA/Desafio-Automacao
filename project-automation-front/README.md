# 🧪 Projeto de Automação — Front-End DemoQA

Automação Front-End desenvolvida com **Java + Selenium + Cucumber + JUnit**, seguindo boas práticas de **BDD** e **Page Object Model (POM)**.

O projeto automatiza funcionalidades do site **DemoQA**, incluindo múltiplas abas, formulários, tabelas e lista ordenada.

---

## 🚀 Fluxos Automatizados

### 1️⃣ Browser Windows (duas abas)
- Acessa o menu **Alerts, Frame & Windows → Browser Windows**
- Abre uma nova aba
- Alterna entre abas
- Valida o conteúdo da nova aba

### 2️⃣ Elements — Web Tables (formulário)
- Acessa **Elements → Web Tables**
- Preenche o formulário de cadastro (First Name, Last Name, Email, Age, Salary, Department)
- Adiciona o registro à tabela
- Valida se o registro foi inserido corretamente

### 3️⃣ Formulário (Geral)
- Preenche um formulário simples em qualquer página suportada
- Submete os dados
- Valida mensagem ou resultado exibido

### 4️⃣ Lista Ordenada — Drag and Drop (Sortable)
- Acessa **Interactions → Sortable**
- Verifica se a lista já está ordenada
- Reordena os elementos se necessário usando **drag and drop**
- Ajusta o item “One” se cair no final
- Valida a ordem final

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Maven**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **JUnit**
- **WebDriverManager**
- **Page Object Model (POM)**
- **Actions API** (drag and drop)
- **JavascriptExecutor** (scroll / click quando necessário)

---


