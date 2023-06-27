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
import br.edu.ifpe.petpalacy.model.entidades.Horarios;
import br.edu.ifpe.petpalacy.model.entidades.Servico;
import br.edu.ifpe.petpalacy.model.entidades.StatusAgen;
import br.edu.ifpe.petpalacy.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    private static Empresa empresa;
    private static Cliente cliente;
    private static Servico servico;
    private static Agendamento agendamento;
    private static AgendamentoModel negocioAgendamento;
    private ArrayList<Agendamento> agendamentos = null;

    private static ClienteModel negocioCliente;
    private static EmpresaModel negocioEmpresa;
    private static ServicoModel negocioServico;
    private Agendamento agendamentoAlterado;
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static final String CLIENTE_NOME = "Carlos junio";
    public static final String CLIENTE_CPF = "11419189433";
    public static final String CLIENTE_TELEFONE = "879812324";
    public static final String CLIENTE_EMAIL = "dkpaz@gmail.com";
    public static final String CLIENTE_SENHA = "saosap";
    public static final String EMPRESA_CNPJ = "12602190000104";
    public static final String EMPRESA_NOME = "papapa";
    public static final String EMPRESA_EMAIL = "emp@gmail.com";
    public static final String EMPRESA_TELEFONE = "21212121";
    public static final String SERVICO_DESCRICAO = "Limpa cao";
    public static final int SERVICO_DURACAO = 35;
    public static final BigDecimal SERVICO_PRECO = new BigDecimal(56.80);
    public static final String DATA_AGENDAMENTO = "02/09/1902";
    public static final String HORARIO_AGENDAMENTO = "00:13";
    public static final StatusAgen STATUS_AGENDAMENTO = StatusAgen.AGENDADO;

    public static final String SERVICO_DESCRICAO_ALTERADO = "tosa";
    public static final int SERVICO_DURACAO_ALTERADO = 30;
    public static final BigDecimal SERVICO_PRECO_ALTERADO = new BigDecimal(50);
    public static final String DATA_AGENDAMENTO_ALTERADO = "03/09/1998";
    public static final String HORARIO_AGENDAMENTO_ALTERADO = "8:00";
    public static final StatusAgen STATUS_AGENDAMENTO_ALTERADO = StatusAgen.ESPERA;


    public NegocioAgendamentoTest() {
        negocioAgendamento = new AgendamentoModel();
        agendamentos = new ArrayList<>();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        cliente = new Cliente(CLIENTE_NOME, CLIENTE_CPF, CLIENTE_TELEFONE, null, CLIENTE_EMAIL, CLIENTE_SENHA);
        
        ArrayList<Horarios> horarios = new ArrayList<>();
        Horarios ho = new Horarios("8:00");
        Horarios ho1 = new Horarios("8:60");
        Horarios ho2 = new Horarios("4:00");
        Horarios ho3 = new Horarios("7:00");
        Horarios ho4 = new Horarios("9:00");

        horarios.add(ho);
        horarios.add(ho1);
        horarios.add(ho2);
        horarios.add(ho3);
        horarios.add(ho4);

        empresa = new Empresa(EMPRESA_CNPJ, EMPRESA_NOME, EMPRESA_EMAIL, EMPRESA_TELEFONE, "bruno Eletro", null);
        servico = new Servico(SERVICO_DESCRICAO, SERVICO_DURACAO, SERVICO_PRECO, empresa, horarios);      
        agendamento = new Agendamento(servico, cliente, DATA_AGENDAMENTO, HORARIO_AGENDAMENTO, STATUS_AGENDAMENTO);

        negocioCliente = new ClienteModel();
        negocioEmpresa = new EmpresaModel();
        negocioServico = new ServicoModel();

        negocioCliente.salvar(cliente);
        negocioEmpresa.salvar(empresa);
        negocioServico.salvar(servico);
    }

    @Before
    public void setUp() throws Exception {
        negocioAgendamento.salvar(agendamento);

    }
    
      @AfterClass 
      public static void tearDownClass() throws Exception {
Session session = sessionFactory.openSession();
        Transaction transacao = null;
        
        try {
            transacao = session.beginTransaction();
            
            Query consulta = session.createQuery("SELECT a FROM Agendamento a");
            List lista = (List) consulta.list();
            
            for (Object a : lista) {
                session.delete(a);
            }
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            session.close();
        } 
        negocioServico.deletar(servico);
        negocioEmpresa.deletar(empresa);
        negocioCliente.deletar(cliente);

      }
    
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
        agendamentoAlterado = new Agendamento(
            new Servico(SERVICO_DESCRICAO_ALTERADO, SERVICO_DURACAO_ALTERADO, SERVICO_PRECO_ALTERADO, empresa, null),
            cliente,
            DATA_AGENDAMENTO_ALTERADO,
            HORARIO_AGENDAMENTO_ALTERADO,
            STATUS_AGENDAMENTO_ALTERADO
        );

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
