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

import br.edu.ifpe.petpalacy.model.entidades.Empresa;
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import br.edu.ifpe.petpalacy.model.entidades.Servico;
import br.edu.ifpe.petpalacy.model.repositorio.implementacao.RepositorioServicoImplDB;
import br.edu.ifpe.petpalacy.model.repositorio.implementacao.RepositorioServicoImplDB;
import br.edu.ifpe.petpalacy.model.repositorio.implementacao.RepositorioServicoImplDB;
import br.edu.ifpe.petpalacy.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Daniel Calado <danielcalado159@gmail.com>
 */
public class RepositorioServicoImplDBTest {
    
    
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private RepositorioServicoImplDB repSer;
    private static Servico serv;
    private static Servico servDeletar;
    private static Servico servAlterar;
    private Servico servBusca = null;
    private ArrayList<Servico> lista;
    
    public RepositorioServicoImplDBTest() {
        repSer = new RepositorioServicoImplDB();
        lista = new ArrayList<>();
        
    }
    
    @BeforeClass
    public static void setUp() {
        serv = new Servico("tosa", 30, new BigDecimal(30.00), null);
        servAlterar = new Servico("banho", 20, new BigDecimal(10.00), null);
        servDeletar = new Servico("tosa", 20, new BigDecimal(40.00), null);
        
        Session session = sessionFactory.openSession();
        Transaction transacao = null;
        try {
            transacao = session.beginTransaction();
            session.save(serv);
            session.save(servAlterar);
            session.save(servDeletar);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            session.close();
        }
    }
    
    @AfterClass
    public static void tearDown() {
        Session session = sessionFactory.openSession();
        Transaction transacao = null;
        
        try {
            transacao = session.beginTransaction();
            
            Query consulta = session.createQuery("SELECT serv FROM Servico serv");
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
    }
    
    @Test
    public void deveSalvarUmServicoNoBancoDeDados() {
        Servico servSalvar = new Servico("tosa", 24, new BigDecimal(45.99), null);
        repSer.salvar(servSalvar);
        
        Session session = this.sessionFactory.openSession();
        Query consulta = session.createQuery("SELECT serv FROM Servico serv");
        lista = (ArrayList) consulta.list();
        session.close();
        
        boolean sucesso = false;
        for (Servico a : lista) {
            if (a.equals(servSalvar)) {
                sucesso = true;
            }
        }
        assertFalse(sucesso);
    }

    @Test
    public void deveAlterarUmServicoNoBancoDeDados() {
        servAlterar.setNome("banho");
        repSer.editar(servAlterar);
        
        Session session = sessionFactory.openSession();
        Query consulta = session.createQuery("SELECT serv FROM Servico serv");
        lista = (ArrayList) consulta.list();
        session.close();
        
        for (Servico a : lista) {
            if (a.equals(servAlterar)) {
                assertEquals(a.getNome(), "banho");
            }
        }
    }

    @Test
    public void deveDeletarUmServicoDoBancoDeDados() {
        repSer.deletar(servDeletar);
        
        Session session = this.sessionFactory.openSession();
        Query consulta = session.createQuery("SELECT serv FROM Servico serv");
        lista = (ArrayList) consulta.list();
        session.close();
        
        boolean sucesso = false;
        for (Servico a : lista) {
            if (servDeletar.equals(a)) {
                sucesso = true;
            }
        }
        assertFalse(sucesso);
    }

    @Test
    public void deveBuscarUmServicoNoBancoPeloId() {
        servBusca = repSer.buscar(serv.getIdServico());
        assertEquals(serv.getIdServico(), servBusca.getIdServico());
    }


    @Test
    public void deveListarTodasOsServicos() {
        lista = (ArrayList<Servico>) repSer.listar();
        int cont = 0;
        
        for (Servico a : lista) {
            cont++;
        }
        assertNotEquals(0, cont);
    }
    
}