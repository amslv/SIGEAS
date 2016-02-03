/**
 * 
 */
package br.com.iterativejr.data.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import br.com.iterativejr.data.dao.GenericDao;

/**
 * @author edsf (Dumbledore)
 */
public class GenericDaoImpl<T, K> implements GenericDao<T, K> {
	/**
	 * Inicia entityManager pelo persistentContext
	 */
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Classe do DAO
	 */
	private Class<T> tipo;

	/**
	 * Inicia Variaveis
	 */
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		tipo = (Class) pt.getActualTypeArguments()[0];
	}

	/**
	 * cria nova entidade
	 * @return nova entidade
	 */
	public T criar(T entidade) {

		this.entityManager.persist(entidade);

		return entidade;

	}

	/**
	 * busca entidade
	 * @return entidade
	 */
	public T buscarPorId(K id) {

		return (T) this.entityManager.find(tipo, id);
	}

	/**
	 * atualiza entidade
	 * @return entidade
	 */
	public T atualizar(T entidade) {

		T resultado = this.entityManager.merge(entidade);

		this.entityManager.flush();

		this.entityManager.detach(resultado);

		return resultado;
	}

	/**
	 * busca todas entidades
	 * @return entidades
	 */
	public List<T> buscarTodos() {

		Query query = entityManager.createQuery("select t from "
				+ tipo.getName() + " t");

		return query.getResultList();
	}

	/**
	 * apaga entidade
	 * @return entidade
	 */
	public void apagar(T entidade) {

		T apagar = this.entityManager.merge(entidade);
		this.entityManager.remove(apagar);
	}
}
