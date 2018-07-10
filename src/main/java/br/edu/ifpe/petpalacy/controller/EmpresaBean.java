/*MIT License

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

import br.edu.ifpe.petpalacy.model.repositorio.implementacao.RepositorioEmpresaImplDB;
import br.edu.ifpe.petpalacy.model.interfaces.InterfaceEmpresa;
import br.edu.ifpe.petpalacy.model.entidades.Empresa;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */

@ManagedBean
@ViewScoped
public class EmpresaBean {
    private InterfaceEmpresa repositorioEmpresa = null;
    private Empresa cadastrarEmpresa;
    private Empresa selectedEmpresa;

    public EmpresaBean() {
        this.repositorioEmpresa = new RepositorioEmpresaImplDB();
        this.cadastrarEmpresa = new Empresa();
        this.selectedEmpresa = (Empresa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empresaLogado");
    }
    
    public void salvarEmpresaAction() throws Exception {
        this.cadastrarEmpresa.setSenha(this.cadastrarEmpresa.getSenha());
        this.repositorioEmpresa.salvar(this.cadastrarEmpresa);
        this.cadastrarEmpresa = new Empresa();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empresa cadastrado com sucesso!"));
    }
    
    public Empresa buscarEmpresaAction(Integer codigo) {
        return (Empresa) this.repositorioEmpresa.buscar(codigo);
    }
    
    public void editarEmpresaAction() throws Exception {
        this.selectedEmpresa.setSenha(this.selectedEmpresa.getSenha());
        this.repositorioEmpresa.editar(this.selectedEmpresa);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empresa alterado com sucesso!"));
    }
    
    public void excluirEmpresaAction() throws Exception {
        this.repositorioEmpresa.deletar(this.selectedEmpresa);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empresa deletado com sucesso!"));
    }
    
    public List<Empresa> listarEmpresaAction() {
        return this.repositorioEmpresa.listar();
    }

    public InterfaceEmpresa getRepositorioEmpresa() {
        return repositorioEmpresa;
    }

    public void setRepositorioEmpresa(InterfaceEmpresa repositorioEmpresa) {
        this.repositorioEmpresa = repositorioEmpresa;
    }
    
    public Empresa getCadastrarEmpresa() {
        return cadastrarEmpresa;
    }

    public void setCadastrarEmpresa(Empresa cadastrarEmpresa) {
        this.cadastrarEmpresa= cadastrarEmpresa;
    }
    
    public Empresa getSelectedEmpresa() {
        return this.selectedEmpresa;
    }

    public void setSelectedEmpresa(Empresa selectedEmpresa) {
        this.selectedEmpresa = selectedEmpresa;
    }
    
}
