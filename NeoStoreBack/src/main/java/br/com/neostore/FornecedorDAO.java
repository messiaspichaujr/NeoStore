package br.com.neostore;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class FornecedorDAO {

    private final EntityManagerFactory emf;

    public FornecedorDAO() {
        this.emf = Persistence.createEntityManagerFactory("neostore-pu");
    }

    //Métodos endpoints

    //post (criar)
    public Fornecedor salvar(Fornecedor fornecedor) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(fornecedor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return fornecedor;
    }

    //get (listar)
    public List<Fornecedor> listarPaginas(int page, int size) {
        EntityManager em = emf.createEntityManager();

        try {
            // calcula o índice do primeiro resultado, a primeira page page=1 começa no índice 0
            int firstResult = (page - 1) * size;

            // set max results: este metodo diz ao banco para retornar no máximo o número de registro que é definido com o tamanho da page
            // set first result: este metodo do jpa diz ao banco para pular uma quantidade de registros.

            return em.createQuery("SELECT f FROM Fornecedor f ORDER BY f.name", Fornecedor.class).setFirstResult(firstResult).setMaxResults(size).getResultList();
        } finally {
            em.close();
        }
    }

    // get (listar id específico)

    public Fornecedor buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();

        try {
            Fornecedor fornecedor = em.find(Fornecedor.class, id);
            return fornecedor;
        } finally {
            em.close();
        }
    }

    // update (atualizar a entidade)

    public Fornecedor atualizar(Fornecedor fornecedor) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            //o metodo merge é usado para atualizar a entidade que ja existe

            Fornecedor fornecedorAtualizado = em.merge(fornecedor);
            em.getTransaction().commit();
            return fornecedorAtualizado;

        } finally {
            em.close();
        }
    }

    //delete

    public void deletar(long id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Fornecedor fornecedor = em.find(Fornecedor.class, id);

            if (fornecedor != null) {
                em.remove(fornecedor);
            }

            System.out.println("Deletado com sucesso!");

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Metodo para salvar todos de uma vez

    public void salvarTodos(List<Fornecedor> fornecedores) {
        for (Fornecedor fornecedor : fornecedores) {
            this.salvar(fornecedor);
        }
    }
}
