# NeoStore - Desafio Full-Stack (Java + React)

![Status do Projeto](https://img.shields.io/badge/status-concluído-brightgreen)

Aplicação web Full-Stack para o gerenciamento de fornecedores, desenvolvida como um desafio técnico. O backend consiste numa API RESTful em Java (sem Spring Boot) e o frontend numa Single Page Application (SPA) em React.

---

## 🛠️ Tecnologias Utilizadas

| Backend (API RESTful)           | Frontend (SPA)         |
| ------------------------------- | ---------------------- |
| Java 17                         | React 18               |
| Maven                           | Vite                   |
| Jetty (Servidor Embarcado)      | Axios                  |
| JAX-RS (Jersey)                 | Styled-Components    |
| JPA (Hibernate)                 | React-iMask            |
| MySQL                           | VS Code                |
| IntelliJ IDEA                   |                        |

---

## 🚀 Como Executar o Projeto

Siga os passos abaixo para configurar e executar a aplicação completa.

### **1. Ambiente e Banco de Dados**

* **Pré-requisitos:** Git, JDK 17, Maven, Node.js e XAMPP.
* **Clone o Repositório:**
    ```bash
    git clone [https://github.com/messiaspichaujr/seu-repositorio.git](https://github.com/messiaspichaujr/seu-repositorio.git)
    cd seu-repositorio
    ```
* **Configure o Banco de Dados (XAMPP):**
    1.  Inicie os módulos **Apache** e **MySQL** no XAMPP.
    2.  Aceda ao phpMyAdmin (`http://localhost/phpmyadmin`).
    3.  Clique na aba **"Importar"**.
    4.  Clique em "Escolher ficheiro" e selecione o ficheiro `database.sql` que está na raiz deste projeto.
    5.  Clique em **"Executar"** para criar o banco e popular os dados.

### **2. Executar o Backend (IntelliJ IDEA)**

1.  Abra o **IntelliJ IDEA** e selecione **File > Open**, abrindo a pasta `backend-neostore`.
2.  Aguarde o Maven sincronizar as dependências.
3.  Edite o ficheiro `src/main/resources/META-INF/persistence.xml` e configure o seu utilizador e senha do MySQL (padrão do XAMPP: `user="root"` e `password=""`).
4.  Encontre a classe `Main.java`, clique com o botão direito e selecione **Run 'Main.main()'**.
5.  O servidor backend estará a rodar em `http://localhost:8080`.

### **3. Executar o Frontend (VS Code)**

1.  Abra o **VS Code** numa nova janela e selecione **File > Open Folder...**, abrindo a pasta `neostore-frontend`.
2.  Abra um novo terminal (`Ctrl+'`).
3.  Instale as dependências:
    ```bash
    npm install
    ```
4.  Inicie o servidor de desenvolvimento:
    ```bash
    npm run dev
    ```
5.  A aplicação frontend estará disponível no endereço indicado no terminal (geralmente `http://localhost:5173`).

---

## 📋 Endpoints da API

A API expõe os seguintes endpoints, todos sob a base URL `/api`:

| Método HTTP | URL                      | Descrição                               |
| :---------- | :----------------------- | :-------------------------------------- |
| `POST`      | `/fornecedores`          | Cria um novo fornecedor.                |
| `GET`       | `/fornecedores`          | Retorna a lista paginada de fornecedores. |
| `GET`       | `/fornecedores/{id}`     | Retorna um fornecedor específico.       |
| `PUT`       | `/fornecedores/{id}`     | Atualiza um fornecedor existente.       |
| `DELETE`    | `/fornecedores/{id}`     | Deleta um fornecedor.                   |
| `POST`      | `/fornecedores/importar` | Importa uma lista de fornecedores.      |
