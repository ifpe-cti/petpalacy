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
package br.edu.ifpe.petshop.model.repositorio.implementacao;

import br.edu.ifpe.petshop.model.dao.PersistenciaDAO;
import br.edu.ifpe.petshop.model.repositorio.interfaces.RepositorioServico;
import br.edu.ifpe.petshop.model.entidades.Servico;
import java.util.List;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioServicoImpDB implements RepositorioServico<Servico> {
    
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
        return (Servico) PersistenciaDAO.getInstance().listar("SELECT s FROM Servico s WHERE s.id=" + codigo).get(0);
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
