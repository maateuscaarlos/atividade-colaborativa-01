package br.edu.ifpb.dac.bandas.domain;



import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
public class Integrante implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private LocalDate dataDeNascimento;

    @Embedded
    private CPF cpf = new CPF("");

    public Integrante() {
    }

    public Integrante( String nome, LocalDate dataDeNascimento, CPF cpf) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Integrante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", cpf=" + cpf.formatado() +
                '}';
    }
}
