package br.com.iterativejr.data.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import br.com.iterativejr.data.dao.GenericDao;

/**
 * 
 * <p>
 * <b> Implementacao do DAO Generico </b>
 * </p>
 *
 * <p>
 * Implemetacao do DAO Generico atribuindo as funcoes necessarias para manusear
 * persistencia.
 * </p>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 * @author <a href="https://github.com/edsf80">edsf</a>
 *
 * @param <T>
 *            - Tipo do objeto
 * @param <K>
 *            - Tipo do ID
 */
public class GenericDaoImpl<T, K> implements GenericDao<T, K> {

	/**
	 * Entity manager que sera iniciado atraves do persistentcontext
	 */
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Tipo da classe atual
	 */
	private Class<T> tipo;

	/**
	 * Construtor para inicializar e setar variaveis
	 */
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		tipo = (Class) pt.getActualTypeArguments()[0];
	}

	/**
	 * Mais informacoes sobre este metodo em
	 * @see br.com.iterativejr.data.dao.GenericDao#criar (java.lang.Object)
	 */
	public T criar(T entidade) {

		this.entityManager.persist(entidade);

		return entidade;

	}

	/**
	 * Mais informacoes sobre este metodo em
	 * @see br.com.iterativejr.data.dao.GenericDao#buscarPorId (java.lang.Object)
	 */
	public T buscarPorId(K id) {

		return (T) this.entityManager.find(tipo, id);
	}

	/**
	 * Mais informacoes sobre este metodo em
	 * @see br.com.iterativejr.data.dao.GenericDao#atualizar (java.lang.Object)
	 */
	public T atualizar(T entidade) {

		T resultado = this.entityManager.merge(entidade);

		this.entityManager.flush();

		this.entityManager.detach(resultado);

		return resultado;
	}

	/**
	 * Mais informacoes sobre este metodo em
	 * @see br.com.iterativejr.data.dao.GenericDao#buscarTodos (java.lang.Object)
	 */
	public List<T> buscarTodos() {

		Query query = entityManager.createQuery("select t from "
				+ tipo.getName() + " t");

		return query.getResultList();
	}

	/**
	 * Mais informacoes sobre este metodo em
	 * @see br.com.iterativejr.data.dao.GenericDao#apagar (java.lang.Object)
	 */
	public void apagar(T entidade) {

		T apagar = this.entityManager.merge(entidade);
		this.entityManager.remove(apagar);
	}
}
