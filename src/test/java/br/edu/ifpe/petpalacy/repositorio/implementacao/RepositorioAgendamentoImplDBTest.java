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
package br.edu.ifpe.petpalacy.repositorio.implementacao;

import br.edu.ifpe.petpalacy.model.entidades.Agendamento;
import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.entidades.Empresa;
import br.edu.ifpe.petpalacy.model.entidades.Servico;
import br.edu.ifpe.petpalacy.model.entidades.StatusAgen;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioAgendamentoImplDBTest {
 /*   private static Agendamento agendamento = new Agendamento();
    
    @Before
    public void pTest() {
        Cliente cliente = new Cliente();
        cliente.setNome("Jose");
        cliente.setCpf("44444444444");
        cliente.setTelefone("11111111111");
        cliente.setEmail("jose@ifpe.com");
        cliente.setSenha("jose12345");
        
        Empresa empresa = new Empresa();
        empresa.setNome("PetLu");
        empresa.setCnpj("11111111111111");
        empresa.setTelefone("22222222222");
        empresa.setEmail("petlu@ifpe.com");
        empresa.setSenha("petlu12345");
        
        Servico servico = new Servico();
        servico.setNome("Banho");
        servico.setDuracao(30);
        servico.setEmpresa(empresa);
        servico.setValor(new BigDecimal("40.00"));
        
        agendamento.setCliente(null);
        agendamento.setData(new Date());
        agendamento.setEmpresa(null);
        agendamento.setServico(null);
        agendamento.setValorTotal(new BigDecimal("30"));
        agendamento.setStatusAgen(StatusAgen.AGENDADO);
       
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        repAgendamento.salvar(agendamento);
    }
    
    @After
    public void downTest() {
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        // saber se existe esse agendamento 
        repAgendamento.deletar(agendamento);  
    }
    
    @Test
    //@Ignore
    public void deveSalvarAgendamentosTest() {        
        Agendamento agendamentoSalv = new Agendamento();
        agendamentoSalv.setCliente(null);
        agendamentoSalv.setData(new Date());
        agendamentoSalv.setEmpresa(null);
        agendamentoSalv.setServico(null);
        agendamentoSalv.setValorTotal(new BigDecimal("30"));
        agendamentoSalv.setStatusAgen(StatusAgen.ESPERA);
        
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        repAgendamento.salvar(agendamentoSalv);
        
        assertEquals(agendamentoSalv.getId(), repAgendamento.buscar(agendamentoSalv.getId()).getId());
    }
    
    @Test
    //@Ignore
    public void deveListarTodosOsAgendamentosTest() {
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        List<Agendamento> agendamentos = repAgendamento.listar();
        
        
        assertEquals(4, agendamentos.size());
    }
   
    @Test
    //@Ignore
    public void deveBuscarAgendamentosCadastrardosPeloIdTest() {
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        Agendamento agen = repAgendamento.buscar(agendamento.getId());
        //System.out.println(agen.getCliente().getNome());
        
        assertEquals(agendamento.getId(), agen.getId());
    } 
    
    @Test
    //@Ignore
    public void deveEditarAgendamentoCadastradoTest() {
        RepositorioAgendamentoImplDB repAgendamento = new RepositorioAgendamentoImplDB();
        Agendamento agen = repAgendamento.buscar(agendamento.getId());
        agen.setValorTotal(new BigDecimal("50"));
            
        repAgendamento.editar(agen);
        
        assertNotEquals(agendamento.getValorTotal(), agen.getValorTotal());
    }
    
    @Test
    @Ignore
    public void deveExcluirAgendamentoCadastradoTest() {
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        
        Cliente cliente = new Cliente();
        cliente.setNome("PauloTest");
        cliente.setCpf("222222222222");
        cliente.setTelefone("11111111111");
        cliente.setEmail("paulo@ifpe.com");
        cliente.setSenha("paulo12345");
        repCliente.salvar(cliente);
        
        Empresa empresa = new Empresa();
        empresa.setNome("PetDog");
        empresa.setCnpj("555555555555555");
        empresa.setTelefone("99999999999");
        empresa.setEmail("petdog@ifpe.com");
        empresa.setSenha("petdog12345");
        
        RepositorioServicoImplDB repServico = new RepositorioServicoImplDB();
        Servico servico = new Servico();
        servico.setNome("Banho");
        servico.setDuracao(20);
        servico.setEmpresa(empresa);
        servico.setValor(new BigDecimal("40"));
        repServico.salvar(servico);
        
        RepositorioAgendamentoImplDB repAgendamento1 = new RepositorioAgendamentoImplDB();
        Agendamento agen = new Agendamento();
        agen.setCliente(cliente);
        agen.setData(new Date());
        agen.setHora(new Date());
        agen.setEmpresa(empresa);
        agen.setServico(servico);
        agen.setValorTotal(new BigDecimal("40"));
        agen.setStatusAgen(StatusAgen.AGENDADO);
       
        repAgendamento1.salvar(agen);
        int id = 0;
        
        List<Agendamento> agendamentos = repAgendamento1.listar();
        for(Agendamento agendamento1 : agendamentos) {
            if(agen.getHora() == agendamento1.getHora()) {
                id = agendamento1.getId();
            }
        }
        
        if(id != 0) {
           Agendamento excluiAgen  = repAgendamento1.buscar(id);
           repAgendamento1.deletar(excluiAgen);
        }
                
    }
    */
}
