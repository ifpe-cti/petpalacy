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
    private static Servico servico;
    private static Agendamento agendamento;
    private static NegocioAgendamento negocioAgendamento;
    private ArrayList<Agendamento> agendamentos = null;

    private static NegocioCliente negocioCliente;
    private static NegocioEmpresa negocioEmpresa;
    private static NegocioServico negocioServico;
    private Agendamento agendamentoAlterado;

    public NegocioAgendamentoTest() {
        negocioAgendamento = new NegocioAgendamento();
        agendamentos = new ArrayList<>();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

        servico = new Servico("Limpa cao", 4, null, empresa);
        cliente = new Cliente("Carlos junio", "11419189433", "879812324", endereco, "dkpaz@gmail.com", "saosap");
        empresa = new Empresa("12602190000104", "papapa", "emp@gmail.com", "21212121", "bruno Eletro", endereco);
        endereco = new Endereco("rua do Parque", 145, "sao joao", "la em cima");
        agendamento = new Agendamento(servico, cliente, empresa, new Date(), new Date(), new BigDecimal(35), StatusAgen.ESPERA);

        negocioCliente = new NegocioCliente();
        negocioEmpresa = new NegocioEmpresa();
        negocioServico = new NegocioServico();

        negocioCliente.salvar(cliente);
        negocioEmpresa.salvar(empresa);
        negocioServico.salvar(servico);

    }

    @Before
    public void setUp() throws Exception {
        negocioAgendamento.salvar(agendamento);

    }

    /**
     * @AfterClass public static void tearDownClass() throws Exception {
     * negServe.deletar(serve); negCli.deletar(cliente);
     * negEmp.deletar(empresa); negAgen.deletar(agenda);
     *
     *
     * }
     *
     *
     * Test of salvar method, of class NegocioAgendamento.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void test1DeveSalvarAgendamentoNoBanco() throws Exception {

        assertEquals("11419189433", agendamento.getCliente().getCpf());

    }

    @Test(expected = java.lang.Exception.class)
    public void test2DeveDarErroAoSalvar() throws Exception {
        negocioAgendamento.salvar(null);

    }

    @Test
    public void test3DeveAterarAgendamentoNoBanco() throws Exception {
        servico.setNome("toza");
        agendamento.setServico(servico);
        negocioAgendamento.editar(agendamento);

        assertEquals("toza", agendamento.getServico().getNome());

    }

    @Test(expected = java.lang.Exception.class)
    public void test4DeveDarErroAoAlterar() throws Exception {
        negocioAgendamento.salvar(agendamento);
        agendamentoAlterado = new Agendamento(new Servico("toza", 3, new BigDecimal(50), empresa), null, empresa, new Date(), new Date(), new BigDecimal(50), StatusAgen.ESPERA);

        negocioAgendamento.editar(agendamentoAlterado);
    }

    @Test
    public void test5DeveDeletarAgendamentoDoBanco() throws Exception {
        negocioAgendamento.salvar(agendamento);
        negocioAgendamento.deletar(agendamento);

        agendamentos = (ArrayList) negocioAgendamento.listar();

        assertNull(null, negocioAgendamento.buscar(agendamento.getId()));

    }

    @Test(expected = java.lang.Exception.class)
    public void test6DeveDarErroAoDeletar() throws Exception {

        negocioAgendamento.deletar(null);

    }

    @Test
    public void test7DeveListarAgendamentos() throws Exception {
        agendamentos = (ArrayList) negocioAgendamento.listar();

        assertNotEquals(0, agendamentos.size());
    }

    @Test
    public void test8DeveBuscarAgendamentoNoBanco() throws Exception {
        negocioAgendamento.salvar(agendamento);
        Agendamento a = negocioAgendamento.buscar(agendamento.getId());

        assertNotNull(a);
    }

    @Test
    public void test9DeveRetornarNullAoBuscarAgendamento() throws Exception {

        assertNull(negocioAgendamento.buscar(null));
        assertNull(negocioAgendamento.buscar(-1));
    }
}
