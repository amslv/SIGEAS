/**
 * 
 */
package br.com.iterativejr.service.negocio.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.transaction.annotation.Transactional;

import br.com.iterativejr.data.dao.GenericDao;
import br.com.iterativejr.service.negocio.GenericService;

/**
 * 
 * <p>
 * <b> Implementacao do Service Generico </b>
 * </p>
 *
 * @author <a href="https://github.com/edsf80">edsf</a>
 *
 * @param <T> Tipo da classe
 * @param <K> Tipo do ID
 */
public class GenericServiceImpl<T, K> implements GenericService<T, K> {

	protected GenericDao<T, K> dao;

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.iterativejr.service.negocio.GenericService#criar(java.lang.Object)
	 */
	@Transactional
	@Override
	public T criar(@Valid @NotNull T entidade) {

		return dao.criar(entidade);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.iterativejr.service.negocio.GenericService#buscarPorId(java
	 * .lang.Object)
	 */
	@Override
	public T buscarPorId(@NotNull K id) {

		return dao.buscarPorId(id);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.iterativejr.service.negocio.GenericService#atualizar(java.
	 * lang.Object)
	 */
	@Transactional
	@Override
	public T atualizar(@NotNull @Valid T entidade) {

		return dao.atualizar(entidade);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see br.com.iterativejr.service.negocio.GenericService#buscarTodos()
	 */
	@Override
	public List<T> buscarTodos() {
		return dao.buscarTodos();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.iterativejr.service.negocio.GenericService#apagar(java.lang
	 * .Object)
	 */
	@Transactional
	@Override
	public void apagar(@NotNull T entidade) {
		
		dao.apagar(entidade);
	}

}
