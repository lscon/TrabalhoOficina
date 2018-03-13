package br.edu.iff.pooa20172.trabalhooficina.model;

import java.io.Serializable;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by fazenda on 13/03/18.
 */

public class Pecas extends RealmObject implements Serializable{

    @PrimaryKey
    private int id;
    private String nome;
    private String descreicao;

    public Pecas(int id, String nome, String descreicao) {
        this.id = id;
        this.nome = nome;
        this.descreicao = descreicao;
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

    public String getDescreicao() {
        return descreicao;
    }

    public void setDescreicao(String descreicao) {
        this.descreicao = descreicao;
    }
}
