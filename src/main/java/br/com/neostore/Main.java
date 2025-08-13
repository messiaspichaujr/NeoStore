package br.com.neostore;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        //Ele cria as configuração lendo as configurações do persistence.xml.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("neostore-pu");

        // é o objeto que faz as operações no banco
        EntityManager em = emf.createEntityManager();

        System.out.println("Conexão com o banco estabelecida com sucesso!");

        Fornecedor novoFornecedor = new Fornecedor(
                "Espetinho do alemão",
                "contato@espetinhodoalemao.com",
                "Fornecedor de espetinhos",
                "31.391.437/0001-27"
        );

        try{

            em.getTransaction().begin();
            em.persist(novoFornecedor);
            em.getTransaction().commit();

            System.out.println("Fornecedor Salvo com sucesso!");
            System.out.println(novoFornecedor);

        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}