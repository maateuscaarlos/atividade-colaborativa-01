package br.edu.ifpb.dac.bandas.dao;



import br.edu.ifpb.dac.bandas.domain.Banda;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Local
@Stateless(name = "BandaDao")
public class BandaDao {
    @PersistenceContext
    private final EntityManager entityManager;

    public BandaDao() {
        this.entityManager = Persistence.createEntityManagerFactory("bandas").createEntityManager();
    }
    public List<Banda> listarTodos() throws NoResultException {
        return entityManager.createQuery("FROM Banda b").getResultList();
    }


    public void salvar(Banda banda) {
        if (bandaById(banda.getId())==null)
        entityManager.persist(banda);
        else atualizar(banda);
    }


    public void remover(Banda banda) throws NoResultException {
        Banda bandaToRemove = entityManager.find(Banda.class, banda.getId());
        entityManager.remove(bandaToRemove);
    }


    public void atualizar(Banda banda) {
        entityManager.merge(banda);
    }


    public Banda bandaById(int id){
        try {
            return (Banda) entityManager
                    .createQuery("FROM Banda b WHERE b.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();

        }catch (NoResultException n){
            return null;
        }


    }
    public List<Banda> bandaByLocalDeOrigem(String localDeOrigem) throws NoResultException {
        return entityManager
                .createQuery("FROM Banda b WHERE b.localDeOrigem LIKE :localDeOrigem")
                .setParameter("localDeOrigem","%"+ localDeOrigem.toLowerCase()+"%")
                .getResultList();

    }

}
