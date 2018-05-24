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

import br.edu.ifpe.petpalacy.model.entidades.DatasServico;
import br.edu.ifpe.petpalacy.model.entidades.Servico;
import br.edu.ifpe.petpalacy.model.negocio.NegocioServico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Wemerson Diogenes da Silva <wemersondiogenes16@gmail.com>
 */

@ManagedBean
@SessionScoped
public class ControllerServico {
    
    private NegocioServico negServico;
    private Servico servico;
    private ArrayList<Servico> listaServico;
    
    public ControllerServico(){
        negServico = new NegocioServico();
        servico = new Servico();
        listaServico = new ArrayList<>();
    }
    
    public String salvar(DatasServico data){
        servico.setListaDeDatas((List<DatasServico>) data);
        negServico.salvar(servico);
        return "pagina web";
    }
    
    public String buscar(){
        negServico.buscar(servico.getIdServico());
        return "pagina web";
    }
    
    public String alterar(){
        negServico.editar(servico);
        return "pagina web";
    }
    
    public String deletar(){
        negServico.deletar(servico);
        return "pagina web";
    }
    
    public String listar(){
        listaServico = (ArrayList<Servico>) negServico.listar();
        return "pagina web";
    }

    public NegocioServico getNegServico() {
        return negServico;
    }

    public void setNegServico(NegocioServico negServico) {
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
    
}
