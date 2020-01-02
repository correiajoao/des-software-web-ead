package br.com.javaweb.dao;

import java.util.List; 
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import br.com.javaweb.domain.Orientador;
import br.com.javaweb.util.HibernateUtil;

public class OrientadorDAO {

	public void salvar(Orientador orientador) {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); 
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); 
			sessao.save(orientador);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
	public void editar(Orientador orientador) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); 
			sessao.update(orientador);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	public void excluir(Orientador orientador) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(orientador); 
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		} 
		
	}
	
	public List<Orientador> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Orientador>orientadores = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Orientador.listar");
			orientadores = consulta.list(); 
		} catch (RuntimeException ex) {
			throw ex;
			} finally {
				sessao.close();
			}
		 return orientadores;
	}
	
	public Orientador buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Orientador orientador = null;
		try {
			Query consulta = sessao.getNamedQuery("Orientador.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			orientador = (Orientador) consulta.uniqueResult(); 
		} catch (RuntimeException ex) {
			throw ex;
		} finally {	
			sessao.close();
		}
	 return orientador;
	}
}
