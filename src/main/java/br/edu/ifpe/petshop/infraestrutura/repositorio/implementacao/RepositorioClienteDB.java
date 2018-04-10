/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.petshop.infraestrutura.repositorio.implementacao;

import br.edu.ifpe.petshop.infraestrutura.dao.PersistenciaDAO;
import br.edu.ifpe.petshop.infraestrutura.repositorio.interfaces.RepositorioGenerico;
import br.edu.ifpe.petshop.model.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioClienteDB implements RepositorioGenerico<Cliente> {
    
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
        return (Cliente) PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c WHERE c.idCliente=" + codigo).get(0);
    }

    @Override
    public void deletar(Cliente cliente) {
        PersistenciaDAO.getInstance().deletar(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c");
    }
    
    public Cliente autenticar(String email, String senha) {
        return (Cliente) PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c WHERE c.email="+ email +
                " AND c.senha="+ senha).get(0);
    }
    
}
