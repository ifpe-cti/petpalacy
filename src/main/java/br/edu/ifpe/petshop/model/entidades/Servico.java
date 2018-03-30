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
package br.edu.ifpe.petshop.model.entidades;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
/**
 *
 * @author Wemerson Diogenes da Silva <wemersondiogenes16@gmail.com>
 */
public class Servico {
    private int id;
    private String nome;
    private int duracao;
    private BigDecimal valor;
    private List<Date> ListaDeDatas;

    public Servico() {
    }

    public Servico(int id, String nome, int duracao, BigDecimal valor, List<Date> ListaDeDatas) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.valor = valor;
        this.ListaDeDatas = ListaDeDatas;
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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Date> getListaDeDatas() {
        return ListaDeDatas;
    }

    public void setListaDeDatas(List<Date> ListaDeDatas) {
        this.ListaDeDatas = ListaDeDatas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Servico)) {
            return false;
        }
        Servico servico = (Servico) obj;

        if(servico.id == id
                && servico.ListaDeDatas == ListaDeDatas
                && servico.duracao == duracao
                && servico.nome == nome
                && servico.valor == valor) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Servico{" + "id=" + id + ", nome=" + nome + ", duracao=" + duracao + ", valor=" + valor + ", ListaDeDatas=" + ListaDeDatas + '}';
    }
    
    
}
