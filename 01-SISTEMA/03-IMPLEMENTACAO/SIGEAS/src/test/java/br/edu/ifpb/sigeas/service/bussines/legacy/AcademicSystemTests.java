/**
 * 
 */
package br.edu.ifpb.sigeas.service.bussines.legacy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * <p>
 * <b> Classe de testes para login no Sistema Acadêmico </b>
 * </p>
 *
 * <p>
 * Descrição
 * </p>
 * 
 * <pre>
 * @see <a href="http://www.linkreferencia.com">Link de Referencia</a>
 * </pre>
 * 
 * @author <a href="https://github.com/LuizAntonioPS">Luiz Pereira</a>
 *
 */
public class AcademicSystemTests {

	
	@Before
	public void setUp() {
	}

	// Mudar classe de exceção.
	@Test(expected = Exception.class)
	public void LoginNullAndPasswordNotIsNull() {
	}
	
	@Test(expected = Exception.class)
	public void LoginBlankAndPasswordNotIsNull() {
	}

	@Test(expected = Exception.class)
	public void LoginNullAndNullPassword() {
	}
	
	@Test(expected = Exception.class)
	public void LoginBlankAndNullPassword() {
	}

	@Test(expected = Exception.class)
	public void LoginNotRegisteredAndWrongPassword() {
	}

	@Test(expected = Exception.class)
	public void LoginNotRegisteredAndNullPassword() {
	}
	
	@Test(expected = Exception.class)
	public void LoginNotRegisteredAndBlankPassword() {
	}

	@Test(expected = Exception.class)
	public void LoginRegisteredAndNullPassword() {
	}
	
	@Test(expected = Exception.class)
	public void LoginRegisteredAndBlankPassword() {
	}

	@Test(expected = Exception.class)
	public void LoginRegisteredButWrongPassword() {
	}

	@Test(expected = Exception.class)
	public void LoginRegisteredAndCorrectPasswordButIsYourFirstAccess() {
	}
	
	@Test(expected = Exception.class)
	public void LoginRegisteredAndCorrectPasswordButAcademicSystemIsOffline() {
	}
	
	@Test
	public void LoginRegisteredAndCorrectPassword() {
	}

	@After
	public void tearDown() {
	}

}
