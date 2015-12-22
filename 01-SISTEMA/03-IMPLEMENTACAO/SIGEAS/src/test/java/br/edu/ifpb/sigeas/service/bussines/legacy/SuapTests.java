package br.edu.ifpb.sigeas.service.bussines.legacy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * <p>
 * <b> Título </b>
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
public class SuapTests {
	
	@Before
	public void setUp() {
	}

	// Mudar classe de exceção.
	@Test(expected = Exception.class)
	public void UserNullAndPasswordNotIsNull() {
		// método com user null
	}

	@Test(expected = Exception.class)
	public void UserNullAndNullPassword() {
	}

	@Test(expected = Exception.class)
	public void UserNotRegisteredAndPasswordNotIsNull() {
	}

	@Test(expected = Exception.class)
	public void UserNotRegisteredAndNullPassword() {
	}

	@Test(expected = Exception.class)
	public void UserRegisteredAndNullPassword() {
	}

	@Test(expected = Exception.class)
	public void UserRegisteredButWrongPassword() {
	}

	@Test(expected = Exception.class)
	public void UserRegisteredAndCorrectPasswordButWithoutReleasedAccess() {
	}

	@Test(expected = Exception.class)
	public void UserRegisteredAndCorrectPasswordAndReleasedAccessButYourProfileNotIsListed() {
		// É interessante?
	}
	
	@Test(expected = Exception.class)
	public void UserRegisteredAndCorrectPasswordAndReleasedAccessAndProfileListedButSuapIsOffline() {
	}
	
	public void UserRegisteredAndCorrectPasswordAndReleasedAccessAndProfileListed() {
	}

	@After
	public void tearDown() {
	}
}
