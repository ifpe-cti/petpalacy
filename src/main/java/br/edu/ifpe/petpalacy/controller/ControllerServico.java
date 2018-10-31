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
package br.edu.ifpe.petpalacy.controller;

import br.edu.ifpe.petpalacy.model.entidades.Horarios;
import br.edu.ifpe.petpalacy.model.entidades.Servico;
import br.edu.ifpe.petpalacy.model.negocio.ServicoModel;
import br.edu.ifpe.petpalacy.util.Mensagens;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Wemerson Diogenes da Silva <wemersondiogenes16@gmail.com>
 */

@ManagedBean
@SessionScoped
public class ControllerServico {
    
    private ServicoModel negServico;
    private Servico servico;
    private Horarios horas;
    private ArrayList<Servico> listaServico;
    
    public ControllerServico(){
        horas = new Horarios();
        negServico = new ServicoModel();
        servico = new Servico();
        listaServico = new ArrayList<>();
    }
    
    public String salvar(){
        try {
            negServico.salvar(servico);
            limpar();
            Mensagens.getInstance().salvoComSucesso();
            return "meusServicos.xhtml?faces-redirect=true";
        } catch(Exception ex){
            Mensagens.getInstance().nenhumaInformacao();
        }
        return null;
    }
    
    public String alterar(){
        try {
            negServico.editar(servico);
            Mensagens.getInstance().alteradoComSucesso();
            limpar();
             return "meusServicos.xhtml?faces-redirect=true";           
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
        return null;
    }
    
    public String deletar(){
        try {
            negServico.deletar(servico);
            Mensagens.getInstance().deletadoComSucesso();
        return "meusServicos.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
        return null;
    }
    
    public void limpar(){
         horas = new Horarios();
         servico = new Servico();
    }
    
    public void listar(){
        listaServico = (ArrayList<Servico>) negServico.listar();
    }
    public void listarServicosDeEmpresa(int id){
        listaServico = (ArrayList<Servico>) negServico.buscarServicosPorEmpresa(id);
    }
    public void adicionarHorarios(){
        servico.inserirHorario(horas);
        horas = new Horarios();
    }
        public void deletarHorarios(){
        servico.deletarHorario(horas);
        horas = new Horarios();
    }
    public void buscarId(){
        negServico.buscar(servico.getIdServico());
    }

    public ServicoModel getNegServico() {
        return negServico;
    }

    public void setNegServico(ServicoModel negServico) {
        this.negServico = negServico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public ArrayList<Servico> getListaServico() {
        return listaServico;
    }

    public void setListaServico(ArrayList<Servico> listaServico) {
        this.listaServico = listaServico;
    }

    public Horarios getHoras() {
        return horas;
    }

    public void setHoras(Horarios horas) {
        this.horas = horas;
    }

  
    
    
}
