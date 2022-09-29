package com.gugawag.pdist.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Mensagem implements Serializable {
    @Id
    private long id;

    private String texto;

    public Mensagem() { }

    public Mensagem(long id, String texto) {
        this.id    = id;
        this.texto = texto + "\nAdriana Albuquerque de Moura";
    }

    public long getId() {
        return this.id;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return String.format("Mensagem: %s", this.texto);
    }
}
