package br.com.neostore;

import jakarta.persistence.*;

@Entity //representa uma tabela no banco
@Table(name = "fornecedores") //nome da tabela
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false) //mapeia para a coluna name
    private String name;

    @Column(name = "email", nullable = false, unique = true) //mapeia para email e o deixa único
    private String email;

    @Column(name = "description") // mapeia para description
    private String description;

    @Column(name = "cnpj", nullable = false, unique = true, length = 18) //mapeia para o cnpj e o deixa com tam definido e unico
    private String cnpj;

    public Fornecedor() {}

    public Fornecedor(String name, String email, String description, String cnpj) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.cnpj = cnpj;
    }

    //getter e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}

