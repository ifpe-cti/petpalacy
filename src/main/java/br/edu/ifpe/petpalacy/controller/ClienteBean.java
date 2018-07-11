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

import br.edu.ifpe.petpalacy.repositorio.implementacao.RepositorioClienteImplDB;
import br.edu.ifpe.petpalacy.interfaces.InterfaceCliente;
import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import java.io.Serializable;
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
public class ClienteBean implements Serializable {
    private InterfaceCliente repositorioCliente = null;
    private Cliente selectedCliente;
    private Cliente cadastrarCliente;

    public ClienteBean() {
        this.repositorioCliente = new RepositorioClienteImplDB();
        this.cadastrarCliente = new Cliente();
        this.selectedCliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("clienteLogado");
    }
    
    public void salvarClienteAction() throws Exception {
        this.cadastrarCliente.setSenha(this.cadastrarCliente.getSenha());
        this.repositorioCliente.salvar(this.cadastrarCliente);
        this.cadastrarCliente = new Cliente();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente cadastrado com sucesso!"));
    }
    
    public Cliente buscarClienteAction(Integer codigo) {
        return (Cliente) this.repositorioCliente.buscar(codigo);
    }
    
    public void editarClienteAction() throws Exception {
        this.selectedCliente.setSenha(this.selectedCliente.getSenha());
        this.repositorioCliente.editar(this.selectedCliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente alterado com sucesso!"));
    }
    
    public void excluirClienteAction() throws Exception {
        this.repositorioCliente.deletar(this.selectedCliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente deletado com sucesso!"));
    }
    
    public List<Cliente> listarClienteAction() {
        return this.repositorioCliente.listar();
    }

    public InterfaceCliente getRepositorioCliente() {
        return repositorioCliente;
    }

    public void setRepositorioCliente(InterfaceCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }
    
    public Cliente getSelectedCliente() {
        return this.selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    public Cliente getCadastrarCliente() {
        return cadastrarCliente;
    }

    public void setCadastrarCliente(Cliente cadastrarCliente) {
        this.cadastrarCliente = cadastrarCliente;
    }
    
}
