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
    public Fornecedor salvar(Fornecedor fornecedor){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(fornecedor);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return fornecedor;
    }

    //get (listar)
    public List<Fornecedor> listarTodos(){
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("select f from Fornecedor f", Fornecedor.class).getResultList();
        }finally {
            em.close();
        }
    }

    // get (listar id específico)

    public Fornecedor buscarPorId(Long id){
        EntityManager em = emf.createEntityManager();

        try {
            Fornecedor fornecedor = em.find(Fornecedor.class, id);
            return fornecedor;
        }finally {
            em.close();
        }
    }

    // update (atualizar a entidade)

    public Fornecedor atualizar(Fornecedor fornecedor){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            //o metodo merge é usado para atualizar a entidade que ja existe

            Fornecedor fornecedorAtualizado = em.merge(fornecedor);
            em.getTransaction().commit();
            return fornecedorAtualizado;

        }finally {
            em.close();
        }
    }

    //delete

    public void deletar(long id){
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Fornecedor fornecedor = em.find(Fornecedor.class, id);

            if (fornecedor != null){
                em.remove(fornecedor);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
