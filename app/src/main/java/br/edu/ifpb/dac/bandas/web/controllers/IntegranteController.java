package br.edu.ifpb.dac.bandas.web.controllers;


import br.edu.ifpb.dac.bandas.domain.Integrante;
import br.edu.ifpb.dac.bandas.service.IntegranteService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class IntegranteController implements Serializable {

    @EJB
    private IntegranteService integranteService;
    private Integrante integrante;
    private List<Integrante> integrantes;
    private String idIntegrante;
    private String buscarCpf;

    @PostConstruct
    public void init() {
        this.integrante = new Integrante();
        this.integrantes = listarTodosIntegrantes();
    }

    public String criarIntegrante(){
        integranteService.salvar(integrante);
        recuperarNovaInstancia();
        return "list?faces-redirect=true";
    }
    public String buscarPorCpf(){
        this.integrantes = integranteService.integranteComCPF(buscarCpf);
        return "findByCpf?faces-redirect=true";
    }

    public String remover(Integrante integranteRemover){
        integranteService.remover(integranteRemover);
        recuperarNovaInstancia();
        return null;
    }

    public String editarIntegrante(Integrante integranteEditar){
        integranteService.atualizar(integranteEditar);
        return "list?faces-redirect=true";
    }

    public String redirecionarEditar(Integrante integranteEditar){
        this.integrante =  integranteEditar;
        return "edit?faces-redirect=true";
    }

    public List<Integrante> listarTodosIntegrantes() {
      this.integrantes = integranteService.listarTodos();
      return this.integrantes;
    }

    private void recuperarNovaInstancia() {
        this.integrante =  new Integrante();
    }

    public String getIdIntegrante() {
        return idIntegrante;
    }

    public void setIdIntegrante(String idIntegrante) {
        this.idIntegrante = idIntegrante;
    }

    public List<Integrante> getDataDeNascimento() {
        return integranteService.integrantePorNascimento();
    }

    public Integrante getIntegrante() {
        return this.integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    public String getBuscarCpf() {
        return buscarCpf;
    }

    public void setBuscarCpf(String buscarCpf) {
        this.buscarCpf = buscarCpf;
    }
}
