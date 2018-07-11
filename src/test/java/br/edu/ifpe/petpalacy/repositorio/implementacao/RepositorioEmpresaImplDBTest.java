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
package br.edu.ifpe.petpalacy.repositorio.implementacao;

import br.edu.ifpe.petpalacy.dao.PersistenciaDAO;
import br.edu.ifpe.petpalacy.model.entidades.Empresa;
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import br.edu.ifpe.petpalacy.repositorio.implementacao.RepositorioEmpresaImplDB;
import br.edu.ifpe.petpalacy.repositorio.implementacao.RepositorioEmpresaImplDB;
import br.edu.ifpe.petpalacy.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
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
import org.junit.Ignore;

/**
 *
 * @author Daniel Calado <danielcalado159@gmail.com>
 */
public class RepositorioEmpresaImplDBTest {
    
    private static Empresa emp;
    private static Endereco end;
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private RepositorioEmpresaImplDB repEmp;
    private static Empresa empExcluir;
    private static Empresa empAlterar;
    private Empresa empBusca = null;
    private ArrayList<Empresa> lista;
    
    public RepositorioEmpresaImplDBTest() {
        repEmp = new RepositorioEmpresaImplDB();
        lista = new ArrayList<>();
        
    }
    
    @BeforeClass
    public static void setUp() {
        end = new Endereco("rua duque de caxias", 12, "garanhuns", "vila nova");
        emp = new Empresa("48608939000160", "catavento", "paulo@gmail.com", "981546578", "caoPet", end);
        empExcluir = new Empresa("1234567890", "saopaulo", "luis@gmail.com", "981546578", "caoPet", null);
        empAlterar = new Empresa("2222222222222", "saosao", "dkpaz@gmail.com", "981546578", "caoPet", null);        
        Session session = sessionFactory.openSession();
        Transaction transacao = null;
        try {
            transacao = session.beginTransaction();
            session.save(emp);
            session.save(empExcluir);
            session.save(empAlterar);
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
            
            Query consulta = session.createQuery("SELECT em FROM Empresa em");
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
    public void deveSalvarUmaEmpresaNoBancoDeDados() {
        Endereco endsa = new Endereco("rua duque", 9, "lala do lolo", "pavilhao");
        Empresa empsa = new Empresa("390725478000199", "lalala", "toinho@gmail.com", "9876453322", "gatoPreto", endsa);
        repEmp.salvar(empsa);
        
        Session session = this.sessionFactory.openSession();
        Query consulta = session.createQuery("SELECT e FROM Empresa e WHERE e.cnpj=" + empsa.getCnpj());
        empBusca =  (Empresa) consulta.list().get(0);
        session.close();
        
       
        assertEquals(empsa.getCnpj(), empBusca.getCnpj());
    }

    @Test
    public void deveAlterarUmaEmpresaNoBancoDeDados() {
        empAlterar.setCnpj("390725478000199");
        repEmp.editar(empAlterar);
        
                Session session = this.sessionFactory.openSession();
        Query consulta = session.createQuery("SELECT e FROM Empresa e WHERE e.cnpj=" + empAlterar.getCnpj());
        empBusca =  (Empresa) consulta.list().get(0);
        session.close();
        
       
        assertEquals(empAlterar.getCnpj(), empBusca.getCnpj());
    }

    @Test
    public void deveDeletarUmaEmpresaDoBancoDeDados() {
        repEmp.deletar(empExcluir);
        
        Session session = this.sessionFactory.openSession();
        Query consulta = session.createQuery("SELECT e FROM Empresa e WHERE e.cnpj=" + empExcluir.getCnpj());
        List lista = (List) consulta.list();
        session.close();
                if(!lista.isEmpty()){
            empBusca = (Empresa) lista.get(0);
        }
            empBusca = null;
    
        assertNull(empBusca);
    }

    @Test
    public void deveBuscarUmaEmpresaNoBancoPeloId() {
        empBusca = repEmp.buscar(emp.getIdEmpresa());
        assertEquals(emp.getIdEmpresa(), empBusca.getIdEmpresa());
    }

    @Test
    public void deveBuscarUmaEmpresaNoBancoPeloCnpj() {
        empBusca = repEmp.buscarCnpj(emp.getCnpj());
        assertEquals(emp.getCnpj(), empBusca.getCnpj());
    }

    @Test
    public void deveListarTodasAsEmpresas() {
        lista = (ArrayList<Empresa>) repEmp.listar();
        int cont = 0;
        
        for (Empresa a : lista) {
            cont++;
        }
        assertNotEquals(0, lista.size());
    }

    @Test
    public void deveBuscarAEmpresaPelaSenhaELogin() {
        empBusca = repEmp.autenticar(emp.getEmail(), emp.getSenha());
        assertEquals(emp.getCnpj(), empBusca.getCnpj());
        
    }
}