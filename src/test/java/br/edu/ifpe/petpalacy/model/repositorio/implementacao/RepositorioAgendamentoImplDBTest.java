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
package br.edu.ifpe.petpalacy.model.repositorio.implementacao;

import br.edu.ifpe.petpalacy.model.entidades.Agendamento;
import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.entidades.Empresa;
import br.edu.ifpe.petpalacy.model.entidades.Servico;
import br.edu.ifpe.petpalacy.model.entidades.StatusAgen;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioAgendamentoImplDBTest {
   /* @Test
    @Ignore
    public void salvarTest() {
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        Cliente cliente = repCliente.buscar(2);
        
        RepositorioServicoImplDB repServico = new RepositorioServicoImplDB();
        List<Servico> servicos = repServico.listar();
        
        RepositorioEmpresaImplDB repEmpresa = new RepositorioEmpresaImplDB();
        Empresa empresa = repEmpresa.buscar(2);
        
        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setData(new Date());
        agendamento.setEmpresa(empresa);
        agendamento.setServico(servicos);
        agendamento.setValorTotal(new BigDecimal("30"));
        agendamento.setStatusAgn(StatusAgen.AGENDADO);
        
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        repAgendamento.salvar(agendamento);
        
        BigDecimal decimal = new BigDecimal("30");
        
        Assert.assertEquals("Pedro", agendamento.getCliente().getNome());
        Assert.assertEquals(decimal, agendamento.getValorTotal());
    }
    
    @Test
    @Ignore
    public void listarTest() {
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        List<Agendamento> agendamentos = repAgendamento.listar();
        
        for(Agendamento agendamento : agendamentos) {
            System.out.println(agendamentos.get(0).getCliente().getNome());
        }
        
        Assert.assertEquals("Pedro", agendamentos.get(0).getCliente().getNome());
    }
   
    @Test
    @Ignore
    public void buscarTest() {
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        
        Agendamento agendamento = repAgendamento.buscar(1);
        System.out.println(agendamento.getCliente().getNome());
        
        Assert.assertEquals("Pedro", agendamento.getCliente().getNome());
    } 
    
    @Test
    @Ignore
    public void editarTest() {
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        
        Agendamento agendamento = repAgendamento.buscar(1);
        agendamento.setValorTotal(new BigDecimal("50"));
            
        repAgendamento.editar(agendamento);

    }
    
    @Test
    @Ignore
    public void excluirTest() {
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        
        Agendamento agendamento = repAgendamento.buscar(1);
      
        repAgendamento.deletar(agendamento);
    }*/
}
