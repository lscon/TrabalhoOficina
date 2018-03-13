package br.edu.iff.pooa20172.trabalhooficina.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by fazenda on 13/03/18.
 */

public class Servico extends RealmObject implements Serializable {

    @PrimaryKey
    private int id;
    private String nome;
    private float horas;
    private String mecanico;

    public Servico(int id, String nome, float horas, String mecanico) {
        this.id = id;
        this.nome = nome;
        this.horas = horas;
        this.mecanico = mecanico;
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

    public float getHoras() {
        return horas;
    }

    public void setHoras(float horas) {
        this.horas = horas;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }
}
