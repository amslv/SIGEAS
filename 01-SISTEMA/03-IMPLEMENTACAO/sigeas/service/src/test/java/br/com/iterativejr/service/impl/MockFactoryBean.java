/**
 * 
 */
package br.com.iterativejr.service.impl;

import org.mockito.Mockito;
import org.springframework.beans.factory.FactoryBean;

/**
 * Classe do MockFactory 
 *
 * @author <a href="https://github.com/edfs80">edfs</a>
 *
 * @param <T> Tipo da classe
 */
public class MockFactoryBean<T> implements FactoryBean<T> {

	/**
	 * Classe mockada
	 */
	private Class<T> classToBeMocked;
	
	/**
	 * Construtor com a classe
	 * @param classToBeMocked classe mockada
	 */
	public MockFactoryBean(Class<T> classToBeMocked) {
		this.classToBeMocked = classToBeMocked;
	}
	
	/**
	 * Pega objeto 
	 * 
	 * @return tipo
	 */
	@Override
	public T getObject() throws Exception {
		return Mockito.mock(classToBeMocked);
	}

	/**
	 * Pega tipo do objeto
	 * @return tipo
	 */
	@Override
	public Class<?> getObjectType() {
		return classToBeMocked;
	}

	/**
	 * verifica se eh singleton
	 * @return true se for
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
