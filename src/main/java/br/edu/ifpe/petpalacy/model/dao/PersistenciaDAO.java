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
package br.edu.ifpe.petpalacy.model.dao;

import br.edu.ifpe.petpalacy.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class PersistenciaDAO {
    private final SessionFactory sessionFactory;
    private static PersistenciaDAO instance = null;
    
    public static PersistenciaDAO getInstance() {
        if(instance == null) {
            instance = new PersistenciaDAO();
        }
        return instance;
    }
    
    private PersistenciaDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
       
    public void salvar(Object o) {
        Session session = this.sessionFactory.openSession();
        Transaction transacao = null;
        
        try {
            transacao = session.beginTransaction();
            session.save(o);
            transacao.commit();
        } catch(RuntimeException ex) {
            if(transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            session.close();
        }
        
    }

    public List listar(String sql) {
        Session session = this.sessionFactory.openSession();
        List lista = null;
        
        try {
            Query consulta = session.createQuery(sql);
            lista = (List) consulta.list();
        } catch(RuntimeException ex) {
            throw ex;
        } finally {
                session.close();
        }
        
        return lista;
        
    }

    public void editar(Object o) {
        Session session = this.sessionFactory.openSession();
        Transaction transacao = null;
        
        try {
            transacao = session.beginTransaction();
            session.update(o);
            transacao.commit();
        } catch(RuntimeException ex) {
            if(transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            session.close();
        }
        
    }

    public void deletar(Object o) {
        Session session = this.sessionFactory.openSession();
        Transaction transacao = null;
        
        try {
            transacao = session.beginTransaction();
            session.delete(o);
            transacao.commit();
        } catch(RuntimeException ex) {
            if(transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            session.close();
        }
        
    }
    
    public Object autenticar(String sql, String email, String senha) {
        Session session = this.sessionFactory.openSession();
        Object obj = null;
        
        try {
            Query consulta = session.createQuery(sql +" WHERE a.email = :email AND a.senha = :senha");
            consulta.setString("email", email);
            consulta.setString("senha", senha);
            obj = consulta.uniqueResult();
        } catch(RuntimeException ex) {
            throw ex;
        } finally {
                session.close();
        }
        
        return obj;
        
    }
    
}
