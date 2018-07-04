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
import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.entidades.Empresa;
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import br.edu.ifpe.petpalacy.model.entidades.Servico;
import br.edu.ifpe.petpalacy.model.entidades.StatusAgen;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Izaquiel Cavalcante Da Silva
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NegocioAgendamentoTest {

    private static Endereco endereco;
    private static Empresa empresa;
    private static Cliente cliente;
    private static Servico serve;
    private static Agendamento agenda;
    private static NegocioAgendamento negAgen;
    private ArrayList<Agendamento> list = null;

    private static NegocioCliente negCli;
    private static NegocioEmpresa negEmp;
    private static NegocioServico negServe;
    public NegocioAgendamentoTest() {
        negAgen = new NegocioAgendamento();
        list = new ArrayList<>();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        endereco = new Endereco("rua do Parque", 145, "sao joao", "la em cima");
        empresa = new Empresa("12602190000104", "papapa", "emp@gmail.com", "21212121", "bruno Eletro", endereco);
        cliente = new Cliente("Carlos junio", "11419189433", "879812324", endereco, "dkpaz@gmail.com", "saosap");
        serve = new Servico("Limpa ku", 4, null, empresa);
        agenda = new Agendamento(serve, cliente, empresa, new Date(), new Date(), null, StatusAgen.ESPERA);

        /*negCli = new NegocioCliente();
         negEmp = new NegocioEmpresa();
         negServe = new NegocioServico();
        
         negCli.salvar(cliente);
         negEmp.salvar(empresa);
         negServe.salvar(serve);
         */
        negAgen.salvar(agenda);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        /* 
         negCli.deletar(cliente);
         negEmp.deletar(empresa);
         negServe.deletar(serve);
         */
        negAgen.deletar(agenda);
    }

    /**
     * Test of salvar method, of class NegocioAgendamento.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test1SalvarAgendamentoNoBanco() throws Exception {
        negAgen.salvar(agenda);

        list = (ArrayList) negAgen.listar();

        assertEquals("11419189433", list.get(0).getCliente().getCpf());

    }

    @Test(expected = Exception.class)
    public void test2ErroAoSalvarNoBanco() throws Exception {
        negAgen.salvar(agenda);
        
    }

    @Test
    public void test3AterarAgendamento() throws Exception {
        negAgen.salvar(agenda);
       
       Agendamento altAgen  = new Agendamento(new Servico("toza", 3, new BigDecimal(50), empresa)
               , cliente, empresa, new Date(), new Date(), new BigDecimal(50), StatusAgen.ESPERA);
       
       negAgen.editar(altAgen);
       
       list = (ArrayList) negAgen.listar();
       
        for (Agendamento a : list) {
            if (!a.getServico().getNome().equals("Limpa ku")){
                assertEquals("toza", a.getServico().getNome());
            }
        }
       
          }
}
