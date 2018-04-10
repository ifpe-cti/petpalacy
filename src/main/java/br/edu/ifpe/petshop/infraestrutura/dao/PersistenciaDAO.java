/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.petshop.infraestrutura.dao;

import br.edu.ifpe.petshop.util.HibernateUtil;
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
        List<Object> lista = null;
        
        try {
            Query consulta = session.createQuery(sql);
            //List<Object> lista = (List<Object>) consulta.list().get(0);
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
            throw ex; //Não estar tratando, esta lançando a excerssao
        } finally {
            session.close();
        }
        
    }
    
}
