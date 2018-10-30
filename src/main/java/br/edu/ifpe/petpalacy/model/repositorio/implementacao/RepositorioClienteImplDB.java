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
package br.edu.ifpe.petpalacy.model.repositorio.implementacao;

import br.edu.ifpe.petpalacy.model.dao.PersistenciaDAO;
import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.interfaces.InterfaceCliente;
import java.util.List;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioClienteImplDB implements InterfaceCliente<Cliente> {
    
    @Override
    public void salvar(Cliente cliente) {
        PersistenciaDAO.getInstance().salvar(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        PersistenciaDAO.getInstance().editar(cliente);
    }

    @Override
    public Cliente buscar(Integer codigo) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c WHERE c.id=" + codigo);
        if(!lista.isEmpty()){
            return (Cliente) lista.get(0);
        }
            return null;
        
    }

    @Override
    public void deletar(Cliente cliente) {
        PersistenciaDAO.getInstance().deletar(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c");
    }
    
    @Override
    public Cliente autenticar(String email, String senha) {
        return (Cliente) PersistenciaDAO.getInstance().autenticar("SELECT a FROM Cliente a", email, senha);
    }
    
    @Override
    public Cliente buscarCpf(String cpf){
        List lista =  PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c WHERE c.cpf=" + cpf);
        if(!lista.isEmpty()){
            return (Cliente) lista.get(0);
        }
            return null;
    }
        
}
