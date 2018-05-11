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
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wemerson Diogenes da Silva <wemersondiogenes16@gmail.com>
 */
@Entity
public class Agendamento implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany
    private List<Servico> servico;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Empresa empresa;
    @Temporal(value = TemporalType.DATE)
    private Date data;
    private BigDecimal valorTotal;
    @Enumerated(EnumType.ORDINAL)
    private StatusAgen statusAgen;

    public Agendamento() {
    }

    public Agendamento(Integer id, List<Servico> servico, Cliente cliente, Empresa empresa, Date data, BigDecimal valorTotal, StatusAgen statusAgen) {
        this.id = id;
        this.servico = servico;
        this.cliente = cliente;
        this.data = data;
        this.valorTotal = valorTotal;
        this.empresa = empresa;
        this.statusAgen = statusAgen;
    }

    public StatusAgen getStatusAgn() {
        return statusAgen;
    }

    public void setStatusAgn(StatusAgen statusAgn) {
        this.statusAgen = statusAgen;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

  
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setIdAgen(Integer id) {
        this.id = id;
    }

    public Integer getIdAgen() {
        return id;
    }

    public List<Servico> getServico() {
        return servico;
    }

    public void setServico(List<Servico> servico) {
        this.servico = servico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Agendamento)) {
            return false;
        }
        Agendamento agendamento = (Agendamento) obj;

        if(agendamento.id == id
                && agendamento.cliente == cliente
                && agendamento.data == data
                && agendamento.servico == servico
                && agendamento.empresa == empresa
                && agendamento.valorTotal == valorTotal
                && agendamento.statusAgen == statusAgen) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "id=" + id + ", servico=" + servico + ", cliente=" 
                + cliente + ",empresa" + empresa + ", data=" + data + ", valorTotal=" 
                + valorTotal + "statusAgn"+ statusAgen + '}';
    }
    
    
}
