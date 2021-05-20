package br.edu.ifpb.dac.bandas.web.controllers;

import br.edu.ifpb.dac.bandas.domain.Banda;
import br.edu.ifpb.dac.bandas.domain.Integrante;
import br.edu.ifpb.dac.bandas.service.BandaService;
import br.edu.ifpb.dac.bandas.service.IntegranteService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named
@SessionScoped
public class BandaController implements Serializable {

    @EJB
    private BandaService bandaService;

    @EJB
    private IntegranteService integranteService;

    private List<Banda> bandas;

    private Banda banda;

    private Integrante integrante;

    private String idIntegrante;

    private String localBanda;

    @PostConstruct
    public void init() {
        this.banda = new Banda();
        this.bandas = listar();
        this.integrante =  new Integrante();
    }

    public void bandaById(int id){
        this.banda= this.bandaService.bandaById(id);

    }

    public String criarBanda(){
        bandaService.salvar(banda);
        recuperarNovaInstancia();
        return "list?faces-redirect=true";
    }

    public String adicionarIntegrante(){
        int valor1 = Integer.valueOf(idIntegrante);
        this.integrante=integranteService.integranteComId(valor1);
        this.banda.getIntegrantes().add(this.integrante);
        editarBanda(this.banda);
        recuperarNovaInstancia();
        this.bandas= listar();
        System.out.println(bandas);
        return "list?faces-redirect=true";
    }

    public String redirecionarBuscarPorLocal(){
        this.bandas = null;
        return "findByLocal?faces-redirect=true";
    }

    public String buscarBandaLocal(){
        this.bandas = this.bandaService.bandaByLocalDeOrigem(localBanda);
        return null;
    }

    public String removerBanda(Banda bandaRemover){
        bandaService.remover(bandaRemover);
        recuperarNovaInstancia();
        return null;
    }

    public String editarBanda(Banda bandaEditar){
        bandaService.atualizar(bandaEditar);
        return "list?faces-redirect=true";
    }

    public String redirecionarEditar(Banda bandaEditar){
        this.banda =  bandaEditar;
        return "edit?faces-redirect=true";
    }

    private void recuperarNovaInstancia() {
        this.banda =  new Banda();
    }

    public List<Banda> listar() {
        return bandaService.listarTodos();
    }

    public Banda getBanda() {
        return this.banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public List<Banda> getBandas() {
        return bandas;
    }

    public void setBandas(List<Banda> bandas) {
        this.bandas = bandas;
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }

    public String getIdIntegrante() {
        return idIntegrante;
    }

    public void setIdIntegrante(String idIntegrante) {
        this.idIntegrante = idIntegrante;
    }

    public String getLocalBanda() {
        return localBanda;
    }

    public void setLocalBanda(String localBanda) {
        this.localBanda = localBanda;
    }
}
