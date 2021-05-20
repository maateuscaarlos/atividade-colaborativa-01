package br.edu.ifpb.dac.bandas.service;



import br.edu.ifpb.dac.bandas.dao.BandaDao;
import br.edu.ifpb.dac.bandas.domain.Banda;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.List;

@Local
@Stateless
public class BandaService {
    @EJB
    private BandaDao bandaDao;

    public BandaService() {
        this.bandaDao =  new BandaDao();
    }

    public List<Banda> listarTodos() {
        return bandaDao.listarTodos();
    }

    public int salvar(Banda banda) {
        bandaDao.salvar(banda);
        return banda.getId();
    }

    public void remover(Banda banda) {
        try {
            bandaDao.remover(banda);
        } catch (NoResultException ex) {
//            ex.printStackTrace();
        }
    }

    public void atualizar(Banda banda) {
        bandaDao.atualizar(banda);
    }

    public Banda bandaById(int id) {
        try {
            return bandaDao.bandaById(id);

        } catch (NoResultException ex) {
            return null;
        }

    }
    public List<Banda> bandaByLocalDeOrigem (String local) {
        try {
            return bandaDao.bandaByLocalDeOrigem(local);

        } catch (NoResultException ex) {
            return null;
        }

    }

}
