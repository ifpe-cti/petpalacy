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

import br.edu.ifpe.petpalacy.model.repositorio.implementacao.RepositorioClienteImplDB;
import br.edu.ifpe.petpalacy.model.repositorio.implementacao.RepositorioEmpresaImplDB;
import br.edu.ifpe.petpalacy.model.entidades.Empresa;
import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.negocio.ClienteModel;
import br.edu.ifpe.petpalacy.model.negocio.EmpresaModel;
import br.edu.ifpe.petpalacy.util.Criptografia;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */

@ManagedBean
@SessionScoped
public class AutenticarBean implements Serializable {
    private String email;
    private String senha;
    private Cliente clienteLogin = null;
    private Empresa empresaLogin = null;

public AutenticarBean(){
    clienteLogin = new Cliente();
    empresaLogin = new Empresa();
}
    
    public String entrar() {
        if(email == null) {
            System.out.println("valor nulo para email.");
        }
        if(senha == null) {
            System.out.println("valor nulo para senha.");
        }
        senha = Criptografia.criptografar(senha);
        ClienteModel neg = new ClienteModel();
        clienteLogin = neg.autenticar(email, senha);
        
        if(clienteLogin != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você esta Logado!"));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clienteLogado", this.clienteLogin);
            return "Cliente/visualizarServicos.xhtml?faces-redirect=true";
        } else {
            EmpresaModel negEmp = new EmpresaModel();
            empresaLogin = negEmp.autenticar(email, senha);
            
            if(empresaLogin != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você esta Logado!"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empresaLogado", this.empresaLogin);
                return "Empresa/meusAgendamentos.xhtml?faces-redirect=true";
            }
        }
        
        if(clienteLogin == null && empresaLogin == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro ao fazer login!"));
        }
        
        return "index.xhtml";
        
    }
    
    public String sair() {
        clienteLogin = null;
        empresaLogin = null;
        email = "";
        senha = "";
        return "../index.xhtml?faces-redirect=true";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente getClienteLogin() {
        return clienteLogin;
    }

    public void setClienteLogin(Cliente clienteLogin) {
        this.clienteLogin = clienteLogin;
    }

    public Empresa getEmpresaLogin() {
        return empresaLogin;
    }

    public void setEmpresaLogin(Empresa empresaLogin) {
        this.empresaLogin = empresaLogin;
    }


    
}
