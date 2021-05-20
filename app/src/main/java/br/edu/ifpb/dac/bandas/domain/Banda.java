package br.edu.ifpb.dac.bandas.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Banda implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String localDeOrigem;
    private String nomeFantasia;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Integrante> integrantes =  new ArrayList<>();

    public Banda() {
    }

    public Banda( String localDeOrigem, String nomeFantasia, List<Integrante> integrantes) {
        this.localDeOrigem = localDeOrigem;
        this.nomeFantasia = nomeFantasia;
        this.integrantes = integrantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }



    @Override
    public String toString() {
        return "Banda{" +
                "id=" + id +
                ", localDeOrigem='" + localDeOrigem + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", integrantes=" + integrantes +
                '}';
    }
}
