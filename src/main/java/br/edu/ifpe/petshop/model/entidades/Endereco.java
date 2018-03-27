/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.petshop.model.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Wemerson Diogenes da Silva <wemersondiogenes16@gmail.com>
 */
@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String logradouro;
    private String cidade;
    private String bairro;

    public Endereco() {
    }

    public Endereco(int id, String logradouro, String cidade, String bairro) {
        this.id = id;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Endereco)) {
            return false;
        }
        Endereco endereco = (Endereco) obj;

        if(endereco.id == id
                && endereco.bairro == bairro
                && endereco.cidade == cidade
                && endereco.logradouro == logradouro) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", logradouro=" + logradouro + ", cidade=" + cidade + ", bairro=" + bairro + '}';
    }

}
