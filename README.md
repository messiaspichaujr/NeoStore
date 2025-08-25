# NeoStore

Aplicação web Full-Stack para o gerenciamento de fornecedores, desenvolvida como um desafio técnico. O backend consiste numa API RESTful em Java e o frontend em React.
---

## 🚀 Como Rodar o Projeto

### 1. Pré-requisitos
- Git  
- JDK 17  
- Maven  
- XAMPP (MySQL + phpMyAdmin)  

---

### 2. Banco de Dados
1. Inicie **Apache** e **MySQL** no XAMPP.  
2. Acesse o [phpMyAdmin](http://localhost/phpmyadmin).  
3. Vá até **Importar**.  
4. Selecione o arquivo `database.sql` (raiz do projeto).  
5. Clique em **Executar** para criar o banco e popular os dados.  

---

### 3. Backend (Java)
1. Abra a pasta `NeoStoreBack` no **IntelliJ IDEA**.  
2. Aguarde o Maven baixar as dependências.  
3. Configure usuário e senha do MySQL em src/main/resources/META-INF/persistence.xml
   (obs: Não configurei Usuário admin no banco, esta o padrão que é user: root e senha vazia "");
4. Rode a classe `Main.java`.  
5. O backend estará disponível em: http://localhost:8080

---

### 4. Frontend (React)
1. Abra a pasta `NeoStoreFront` no **VS Code**.  
2. No terminal, instale as dependências:  
```bash
npm install
npm run dev
http://localhost:5173

🛠 Tecnologias Utilizadas
Backend	/ Frontend
Java 17 / React
Maven / Vite
Jetty / Axios
JAX-RS / Styled-Components
JPA (Hibernate)
MySQL	
	
