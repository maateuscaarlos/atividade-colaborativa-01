package br.edu.ifpb.dac.bandas.domain;

import javax.persistence.Embeddable;

@Embeddable
public class CPF {
    private static final int TAMANHO = 11;
    private String cpf;

    public CPF() {
    }

    public CPF(String numero) {
        this.cpf = numero;
    }

    public boolean valido() {
        return this.cpf.length() == TAMANHO;
    }

    public String formatado() {
        return String.format(
                "%s.%s.%s-%s",
                this.cpf.substring(0,3),
                this.cpf.substring(3,6),
                this.cpf.substring(6,9),
                this.cpf.substring(9,11)
        );
    }

    public String valor() {
        return this.cpf;
    }
}
