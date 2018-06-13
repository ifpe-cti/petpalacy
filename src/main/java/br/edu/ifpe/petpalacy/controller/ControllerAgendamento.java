/**
 * MIT License
 *
 * Copyright (c) 2018 Daniel da Silva Calado, Izaquiel Cavalcante da Silva,    
 *             Kaio Cesar Bezerra da Silva e Wemerson Diogenes da Silva
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
package br.edu.ifpe.petpalacy.controller;

import br.edu.ifpe.petpalacy.model.entidades.Agendamento;
import br.edu.ifpe.petpalacy.model.negocio.NegocioAgendamento;
import br.edu.ifpe.petpalacy.util.Mensagens;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
@ManagedBean
@SessionScoped
public class ControllerAgendamento implements Serializable {

    private NegocioAgendamento negAgenda;
    private Agendamento agenda;
    private ArrayList<Agendamento> listaAgenda;
    private String ret = "";

    public ControllerAgendamento() {
        negAgenda = new NegocioAgendamento();
        agenda = new Agendamento();
        listaAgenda = new ArrayList<>();
    }

    public String salvar() {
        try {
            negAgenda.salvar(agenda);
            Mensagens.getInstance().salvoComSucesso();
            ret = "pagina com o que foi agendado";
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
        return ret;
    }

    public String buscar() {
        negAgenda.buscar(agenda.getId());
        return "pagina com informações da entidade";
    }

    public String alterar() {
        try {
            negAgenda.editar(agenda);
            Mensagens.getInstance().alteradoComSucesso();
            ret = "pagina com o que foi editado";
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
        return ret;
    }

    public String deletar() {
        try {
            negAgenda.deletar(agenda);
            Mensagens.getInstance().deletadoComSucesso();
            ret = "pagina com todos os agendamentos";
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
        return ret;
    }

    public String listar() {
        listaAgenda = (ArrayList) negAgenda.listar();
        return "pagina com todos os agendamentos";
    }

    public NegocioAgendamento getNegAgenda() {
        return negAgenda;
    }

    public void setNegAgenda(NegocioAgendamento negAgenda) {
        this.negAgenda = negAgenda;
    }

    public Agendamento getAgenda() {
        return agenda;
    }

    public void setAgenda(Agendamento agenda) {
        this.agenda = agenda;
    }

    public ArrayList<Agendamento> getListaAgenda() {
        return listaAgenda;
    }

    public void setListaAgenda(ArrayList<Agendamento> listaAgenda) {
        this.listaAgenda = listaAgenda;
    }

}
