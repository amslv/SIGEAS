/**
 * 
 */
package br.com.iterativejr.data.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import br.com.iterativejr.data.dao.PermissionEmployeeDao;
import br.com.iterativejr.domains.entidade.PermissionEmployee;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

/**
 * 
 * @author angus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-application-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("/testdataset.xml")
public class AccessSocialWorkerDaoImplTest {

	@Autowired
	@Qualifier("permissionEmployeeDao")
	private PermissionEmployeeDao permissionEmployeeDao;

	@Test
	@Transactional
	public void testeCriar() {
		PermissionEmployee permissionEmployee = new PermissionEmployee();
		permissionEmployee.setMatricula("123456");
		Assert.assertTrue(permissionEmployeeDao.criar(permissionEmployee).getId() != null);
	}
	
	@Test
	@Transactional
	public void testeCriarAtributoNulo() {
		PermissionEmployee permissionEmployee = new PermissionEmployee();
		permissionEmployee.setMatricula(null);
		Assert.assertTrue(permissionEmployeeDao.criar(permissionEmployee).getId() != null);
	}

	@Test
	public void testeBuscarPorId() {
		PermissionEmployee permissionEmployee = permissionEmployeeDao
				.buscarPorId(71l);
		Assert.assertTrue(permissionEmployee != null);
	}

	@Test
	public void testeBuscarPorIdInexistente() {
		PermissionEmployee permissionEmployee = permissionEmployeeDao
				.buscarPorId(666l);
		Assert.assertTrue(permissionEmployee == null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testeBuscarPorIdParamNulo() {
		permissionEmployeeDao.buscarPorId(null);
	}


	@Test
	public void testeBuscarPorMatricula() {
		PermissionEmployee permissionEmployee = permissionEmployeeDao
				.buscaPorMatricula("matricula");
		Assert.assertTrue(permissionEmployee != null);
		Assert.assertTrue(71l == permissionEmployee.getId());
	}
	
	@Test
	public void testeBuscarPorMatriculaInexistente() {
		PermissionEmployee permissionEmployee = permissionEmployeeDao.buscaPorMatricula("naoexiste");
		Assert.assertNull(permissionEmployee);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testeBuscarPorMatriculaParamNulo() {
		permissionEmployeeDao.buscarPorId(null);
	}
	
	@Test
	public void testeBuscarTodos() {

		List<PermissionEmployee> permissionEmployees = permissionEmployeeDao
				.buscarTodos();

		Assert.assertNotNull(permissionEmployees);
		Assert.assertTrue(permissionEmployees.size()>0);
	}

	@Test
	public void testeVerificarAcessoLiberado() {

		boolean resultado = permissionEmployeeDao
				.verificaAcesso("matricula");

		Assert.assertTrue(resultado);
	}

	@Test
	public void testeVerificarAcessoNaoLiberado() {

		boolean resultado = permissionEmployeeDao
				.verificaAcesso("naoexiste");

		Assert.assertFalse(resultado);
	}

	@Test
	public void testeVerificarLoginExisteParametroNulo() {
		boolean resultado = permissionEmployeeDao.verificaAcesso(null);
		Assert.assertFalse(resultado);
	}
	
	@Test
	@Transactional
	public void testeRemoverAcesso() {
		permissionEmployeeDao.apagar(permissionEmployeeDao.buscarPorId(71l));
		Assert.assertTrue(permissionEmployeeDao.buscarPorId(71l) == null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Transactional
	public void testeVerificarRemoverAcessoQueNaoExiste() {
		permissionEmployeeDao.apagar(null);
	}
	
}
