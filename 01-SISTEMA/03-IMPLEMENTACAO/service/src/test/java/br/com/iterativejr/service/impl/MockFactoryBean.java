/**
 * 
 */
package br.com.iterativejr.service.impl;

import org.mockito.Mockito;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author edsf
 *
 */
public class MockFactoryBean<T> implements FactoryBean<T> {

	private Class<T> classToBeMocked;
	
	public MockFactoryBean(Class<T> classToBeMocked) {
		this.classToBeMocked = classToBeMocked;
	}
	
	@Override
	public T getObject() throws Exception {
		return Mockito.mock(classToBeMocked);
	}

	@Override
	public Class<?> getObjectType() {
		return classToBeMocked;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
