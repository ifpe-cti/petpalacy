/**
 * MIT License
 *
 * Copyright (c) 2018 Daniel da Silva Calado, Izaquiel Cavalcante da Silva,    
 *             Kaio Cesar Bezerra da Silva e Wemerson Diogenes da Silva
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
package br.edu.ifpe.petpalacy.model.negocio;

import br.edu.ifpe.petpalacy.model.entidades.Agendamento;
import br.edu.ifpe.petpalacy.model.interfaces.InterfaceAgendamento;
import br.edu.ifpe.petpalacy.model.repositorio.implementacao.RepositorioAgendamentoImplDB;
import br.edu.ifpe.petpalacy.util.Mensagens;
import java.util.List;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class NegocioAgendamento implements InterfaceAgendamento<Agendamento> {

    private RepositorioAgendamentoImplDB repoAgend;
    private Agendamento agenda;

    public NegocioAgendamento() {
        repoAgend = new RepositorioAgendamentoImplDB();
    }

    @Override
    public void salvar(Agendamento e) {

        if (e == null) {
            //Imprimir que não foi passada nenhuma informação.
            Mensagens.getInstance().nenhumaInformacao();
        } else {

            if (buscar(e.getIdAgen()) == null) {
                //Imprimir que este agendamento já está cadastrado no banco.
                Mensagens.getInstance().jaExisteNoBanco("Agendamento");

            } else {
                repoAgend.salvar(e);
                Mensagens.getInstance().salvoComSucesso();
            }
        }
    }

    @Override
    public Agendamento buscar(Integer codigo) {
        if (codigo == null) {
            //Imprimir que não foi passada nenhuma informação.
            Mensagens.getInstance().nenhumaInformacao();
            return null;
        } else {
            agenda = repoAgend.buscar(codigo);
            if (agenda == null) {
                //Imprimir que não existe esse agendamento cadastrado no banco.
                
                return null;
            } else {
                return agenda;
            }
        }
    }

    @Override
    public void editar(Agendamento e) {
        if (e == null) {
            //Imprimir que não foi passada nenhuma informação.
            Mensagens.getInstance().nenhumaInformacao();
        } else {
            agenda = repoAgend.buscar(e.getIdAgen());

            if (agenda == null) {
                //Imprimir que não existe esse agendamento cadastrado no banco.
                 Mensagens.getInstance().jaExisteNoBanco("Agendamento");               
            } else {
                repoAgend.editar(e);
                //Imprimir Operação realizada com sucesso.
                Mensagens.getInstance().alteradoComSucesso();
            }
        }
    }

    @Override
    public void deletar(Agendamento e) {
        if (e == null) {
            //Imprimir que não foi passada nenhuma informação.
            Mensagens.getInstance().deletadoComSucesso();
        } else {
            agenda = repoAgend.buscar(e.getIdAgen());
            if (agenda == null) {
                //Imprimir que não existe esse agendamento cadastrado no banco.
            } else {
                repoAgend.deletar(e);
                //Imprimir Operação realizada com sucesso.
                 Mensagens.getInstance().salvoComSucesso();
            }
        }

    }

    @Override
    public List<Agendamento> listar() {
        List lista = repoAgend.listar();
        if (lista == null) {
            //Imprimir nada encontrado.
            return null;
        } else {
            return lista;
        }
    }

}
