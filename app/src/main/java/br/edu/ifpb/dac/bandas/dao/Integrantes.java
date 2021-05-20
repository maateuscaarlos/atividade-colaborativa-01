package br.edu.ifpb.dac.bandas.dao;


import br.edu.ifpb.dac.bandas.domain.CPF;
import br.edu.ifpb.dac.bandas.domain.Integrante;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Local
@Stateless(name = "Integrantes")
public class Integrantes {
    @PersistenceContext
    private final EntityManager entityManager;

    public Integrantes() {
        this.entityManager = Persistence.createEntityManagerFactory("bandas").createEntityManager();
    }
    public List<Integrante> listarTodos() throws NoResultException {
        return entityManager.createQuery("FROM Integrante i").getResultList();
    }


    public void salvar(Integrante integrante) {
        if (integranteComId(integrante.getId())==null)
            entityManager.persist(integrante);
        else atualizar(integrante);
    }


    public void remover(Integrante integrante) throws NoResultException {
        Integrante integranteToRemove = entityManager.find(Integrante.class, integrante.getId());
        entityManager.remove(integranteToRemove);
    }


    public void atualizar(Integrante integrante) {
        entityManager.merge(integrante);
    }


    public List<Integrante> integranteComCPF(String cpf) throws NoResultException {
        CPF cpf1 = new CPF(cpf);
        return  entityManager
                .createQuery("FROM Integrante i WHERE i.cpf = :cpf")
                .setParameter("cpf", cpf1)
                .getResultList();

    }
    public Integrante integranteComId(int id){
        try {
        return (Integrante) entityManager
                .createQuery("FROM Integrante i WHERE i.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        }catch (NoResultException n){
            return null;
        }

    }
    public List<Integrante> integrantePorNascimento() throws NoResultException {
        LocalDate localDate1= LocalDate.of(2000, 01, 01);
        LocalDate localDate2= LocalDate.of(2016, 04, 20);
        return entityManager
                .createQuery("from Integrante i where i.dataDeNascimento > :date1 and i.dataDeNascimento < :date2 ")
                .setParameter("date1",localDate1)
                .setParameter("date2",localDate2)
                .getResultList();

    }
}
