/**
 * 
 */
package br.com.iterativejr.service.negocio;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 
 * <p>
 * <b> Service Generico </b>
 * </p>
 *
 * <p>
 * Service Generico para todos os services
 * </p>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 * @param <T>
 *            Tipo da Classe
 * @param <K>
 *            Tipo do ID
 */
public interface GenericService<T, K> {

	/**
	 * Cria Objeto
	 * 
	 * @param entidade
	 *            entidade que sera salva
	 * @return retorna entidade
	 */
	T criar(@Valid @NotNull T entidade);

	/**
	 * Busca por ID
	 * 
	 * @param id
	 *            id do objeto buscado
	 * @return retorna o objeto
	 */
	T buscarPorId(@NotNull K id);

	/**
	 * Atualiza entidade
	 * 
	 * @param entidade
	 *            entidade que sera atualizada
	 * @return entidade
	 */
	T atualizar(@NotNull @Valid T entidade);

	/**
	 * Busca todas entidades
	 * @return retorna entidades
	 */
	List<T> buscarTodos();

	/**
	 * Apaga entidades
	 * 
	 * @param entidade entidade que sera apagada
	 */
	void apagar(@NotNull T entidade);
}
