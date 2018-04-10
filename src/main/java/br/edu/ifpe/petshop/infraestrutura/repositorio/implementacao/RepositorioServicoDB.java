/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.petshop.infraestrutura.repositorio.implementacao;

import br.edu.ifpe.petshop.infraestrutura.dao.PersistenciaDAO;
import br.edu.ifpe.petshop.infraestrutura.repositorio.interfaces.RepositorioGenerico;
import br.edu.ifpe.petshop.model.entidades.Servico;
import java.util.List;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioServicoDB implements RepositorioGenerico<Servico> {
    
    @Override
    public void salvar(Servico servico) {
        PersistenciaDAO.getInstance().salvar(servico);
    }

    @Override
    public void editar(Servico servico) {
        PersistenciaDAO.getInstance().editar(servico);
    }

    @Override
    public Servico buscar(Integer codigo) {
        return (Servico) PersistenciaDAO.getInstance().listar("SELECT s FROM Servico s WHERE s.codigoServ=" + codigo).get(0);
    }

    @Override
    public void deletar(Servico servico) {
        PersistenciaDAO.getInstance().deletar(servico);
    }

    @Override
    public List<Servico> listar() {
        return PersistenciaDAO.getInstance().listar("SELECT s FROM Servico s");
    }
    
}
