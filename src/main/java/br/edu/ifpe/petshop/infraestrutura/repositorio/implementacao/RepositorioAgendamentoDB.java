/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.petshop.infraestrutura.repositorio.implementacao;

import br.edu.ifpe.petshop.infraestrutura.dao.PersistenciaDAO;
import br.edu.ifpe.petshop.infraestrutura.repositorio.interfaces.RepositorioGenerico;
import br.edu.ifpe.petshop.model.entidades.Agendamento;
import java.util.List;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioAgendamentoDB implements RepositorioGenerico<Agendamento> {
    
    @Override
    public void salvar(Agendamento agendamento) {
        PersistenciaDAO.getInstance().salvar(agendamento);
    }

    @Override
    public void editar(Agendamento agendamento) {
        PersistenciaDAO.getInstance().editar(agendamento);
    }

    @Override
    public Agendamento buscar(Integer codigo) {
        return (Agendamento) PersistenciaDAO.getInstance().listar("SELECT ag FROM Agendamento ag WHERE ag.codigoAgen=" + codigo).get(0);
    }

    @Override
    public void deletar(Agendamento agendamento) {
        PersistenciaDAO.getInstance().deletar(agendamento);
    }

    @Override
    public List<Agendamento> listar() {
        return PersistenciaDAO.getInstance().listar("SELECT ag FROM Agendamento ag");
    }
    
}
