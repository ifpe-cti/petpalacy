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
import br.edu.ifpe.petpalacy.model.entidades.Agendamento;
import br.edu.ifpe.petpalacy.model.interfaces.InterfaceAgendamento;
import java.util.List;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioAgendamentoImplDB implements InterfaceAgendamento<Agendamento> {
    
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
        List lista = PersistenciaDAO.getInstance().listar("SELECT ag FROM Agendamento ag WHERE ag.id=" + codigo);
        if(!lista.isEmpty()){
            return (Agendamento) lista.get(0);
        }
            return null;
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
