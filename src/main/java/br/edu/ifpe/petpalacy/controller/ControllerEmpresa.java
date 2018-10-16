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

import br.edu.ifpe.petpalacy.model.entidades.Empresa;
import br.edu.ifpe.petpalacy.model.negocio.NegocioEmpresa;
import br.edu.ifpe.petpalacy.repositorio.implementacao.RepositorioEmpresaImplDB;
import br.edu.ifpe.petpalacy.util.Mensagens;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniel Calado <danielcalado159@gmail.com>
 */
@ManagedBean
@SessionScoped
public class ControllerEmpresa implements Serializable {

    private NegocioEmpresa negEmpresa;
    private Empresa empresa;
    private ArrayList<Empresa> listaEmpresa;
    private String ret = "";

    public ControllerEmpresa() {
        negEmpresa = new NegocioEmpresa();
        empresa = new Empresa();
        listaEmpresa = new ArrayList<>();
    }

    public String salvar() {
        try {

            negEmpresa.salvar(empresa);
            Mensagens.getInstance().salvoComSucesso();
            limpar();
            ret = "Menu empresa";
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
        return ret;
    }

    public String alterar(Empresa emp) {
        try {

            negEmpresa.editar(emp);
            Mensagens.getInstance().alteradoComSucesso();
            ret = "Menu empresa";
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
        return ret;
    }

    public String deletar() {
        try {
            negEmpresa.deletar(empresa);
            Mensagens.getInstance().deletadoComSucesso();
            ret = "pagina inicial";
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
        return ret;
    }
    public void limpar(){
        empresa = new Empresa();
       
    }
    public void listar() {
        listaEmpresa = (ArrayList<Empresa>) negEmpresa.listar();
    }

    public void buscarId() {
        negEmpresa.buscar(empresa.getIdEmpresa());
    }

    public void bu8scarCnpj() {
        negEmpresa.buscarCnpj(empresa.getCnpj());
    }

    public NegocioEmpresa getNegEmpresa() {
        return negEmpresa;
    }

    public void setNegEmpresa(NegocioEmpresa negEmpresa) {
        this.negEmpresa = negEmpresa;
    }

    public ArrayList<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(ArrayList<Empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

}
