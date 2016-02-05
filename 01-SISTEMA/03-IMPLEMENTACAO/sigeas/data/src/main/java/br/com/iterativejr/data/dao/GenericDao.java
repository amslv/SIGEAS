package br.com.iterativejr.data.dao;

import java.util.List;

/**
 * 
 * <p>
 * <b> DAO Generico </b>
 * </p>
 *
 * <p>
 * Classe responsavel por criar interface para todos os daos presentes
 * </p>
 * 
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 * @author <a href="https://github.com/edsf80">edsf</a>
 *
 * @param <T> Tipo da Classe
 * @param <K> Tipo do ID
 */
public interface GenericDao<T, K> {

	/**
	 * Cria objeto
	 * 
	 * @param entidade que sera salva
	 * @return retorna entidade
	 */
	T criar(T entidade);

	/**
	 * Busca a entendade pelo ID
	 * 
	 * @param id id do objeto que sera buscado
	 * @return o objeto retonardo
	 */
	T buscarPorId(K id);

	/**
	 * Atualiza entidade
	 * 
	 * @param entidade entidade que sera alterada
	 * @return entidade alterada
	 */
	T atualizar(T entidade);

	/**
	 * Busca todos os objetos
	 * 
	 * @return todos os objetos
	 */
	List<T> buscarTodos();

	/**
	 * Apaga a entidade
	 * 
	 * @param entidade entidade que sera apagada
	 */
	void apagar(T entidade);
}
