/*
MIT License

Copyright (c) 2018 Daniel da Silva Calado, Izaquiel Cavalcante da Silva, 
                   Kaio Cesar Bezerra da Silva e Wemerson Diogenes da Silva

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package br.edu.ifpe.petpalacy.model.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import br.edu.ifpe.petpalacy.model.entidades.Empresa;

/**
 *
 * @author Wemerson Diogenes da Silva <wemersondiogenes16@gmail.com>
 */
@Entity
public class Servico implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private Integer duracao;
    private BigDecimal valor;
    private Empresa empresa;

    public Servico() {
    }

    public Servico(String nome, Integer duracao, BigDecimal valor, Empresa empresa) {
        this.nome = nome;
        this.duracao = duracao;
        this.valor = valor;
        this.empresa = empresa;
    }

    public Integer getIdServico() {
        return id;
    }

    public void setIdServico(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }
     

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + this.duracao;
        hash = 71 * hash + Objects.hashCode(this.valor);
        return hash;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Servico)) {
            return false;
        }
        Servico servico = (Servico) obj;

        if(servico.id == id
                && servico.duracao == duracao
                && servico.nome == nome
                && servico.valor == valor
                && servico.empresa == empresa) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Servico{" + "id=" + id + ", nome=" + nome + ", duracao=" + duracao + ", valor=" + valor + ", empresa=" + empresa + '}';
    }
 
    
    
}
