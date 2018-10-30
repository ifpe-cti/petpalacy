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
package br.edu.ifpe.petpalacy.repositorio.model.implementacao;

import br.edu.ifpe.petpalacy.model.repositorio.implementacao.RepositorioAgendamentoImplDB;
import br.edu.ifpe.petpalacy.model.entidades.Agendamento;
import br.edu.ifpe.petpalacy.model.entidades.StatusAgen;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioAgendamentoImplDBTest {
  private static int codigoAgendamento;
    
    @BeforeClass
    //@Ignore
    public static void deveSalvarAgendamentosTest() {
        Agendamento agendamentoSalv = new Agendamento();
        agendamentoSalv.setCliente(null);
        agendamentoSalv.setData("12/09/2018");
        agendamentoSalv.setHora("11:45");
        agendamentoSalv.setServico(null);
        agendamentoSalv.setStatusAgen(StatusAgen.AGENDADO);
        
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        repAgendamento.salvar(agendamentoSalv);
        
        codigoAgendamento = agendamentoSalv.getId();
        
        int codigo = repAgendamento.buscar(codigoAgendamento).getId();
        assertEquals(codigoAgendamento, codigo);
    }
    
    @Test
    //@Ignore
    public void deveListarTodosOsAgendamentosTest() {
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        List<Agendamento> agendamentos = repAgendamento.listar();
        boolean listou = agendamentos.size()>0;
        assertEquals(true, listou);
    }
   
    @Test
    //@Ignore
    public void deveBuscarAgendamentosCadastrardosPeloIdTest() {
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB(); 
        int codigo = repAgendamento.buscar(codigoAgendamento).getId();
        assertEquals(codigoAgendamento, codigo);
    } 
    
    @Test
    //@Ignore
    public void deveEditarAgendamentoCadastradoTest() {
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        Agendamento agendamento = repAgendamento.buscar(codigoAgendamento);
        agendamento.setStatusAgen(StatusAgen.AGENDADO);
            
        repAgendamento.editar(agendamento);
        
        assertEquals(StatusAgen.AGENDADO, repAgendamento.buscar(codigoAgendamento).getStatusAgen());
    }
    
    @AfterClass
    //@Ignore
    public static void deveExcluirAgendamentoCadastradoTest() {
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        Agendamento agendamento = repAgendamento.buscar(codigoAgendamento);
        repAgendamento.deletar(agendamento);
    }
    
}
