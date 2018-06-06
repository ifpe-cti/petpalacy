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
 */package br.edu.ifpe.petpalacy.controller;

import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.negocio.NegocioCliente;
import br.edu.ifpe.petpalacy.util.Criptografia;
import br.edu.ifpe.petpalacy.util.Mensagens;
import br.edu.ifpe.petpalacy.util.ValidaCPF;
import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniel Calado <danielcalado159@gmail.com>
 */
@ManagedBean
@SessionScoped
public class ControllerCliente implements Serializable {

    private NegocioCliente negCliente;
    private Cliente cliente;
    private ArrayList<Cliente> listaCliente;

    public ControllerCliente() {
        negCliente = new NegocioCliente();
        cliente = new Cliente();
        listaCliente = new ArrayList<>();
    }

    public void salvar() {
        try {
            negCliente.salvar(cliente);
            Mensagens.getInstance().salvoComSucesso();
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
    }

    public void alterar() {
        try {
            negCliente.editar(cliente);
            Mensagens.getInstance().alteradoComSucesso();
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }
    }

    public void deletar() {
        try {
            negCliente.deletar(cliente);
            Mensagens.getInstance().deletadoComSucesso();
        } catch (Exception ex) {
            Mensagens.getInstance().nenhumaInformacao();
        }        
    }

    public void listar() {
        listaCliente = (ArrayList<Cliente>) negCliente.listar();
    }

    public void buscarId() {
        negCliente.buscar(cliente.getIdCliente());
    }

    public Cliente buscarCpf() {
        return negCliente.buscarCpf(cliente.getCpf());
    }

    public NegocioCliente getNegCliente() {
        return negCliente;
    }

    public void setNegCliente(NegocioCliente negCliente) {
        this.negCliente = negCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

}
