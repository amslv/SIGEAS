package br.com.iterativejr.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.iterativejr.data.dao.PermissionEmployeeDao;
import br.com.iterativejr.domains.entidade.PermissionEmployee;
import br.com.iterativejr.service.negocio.PermissionEmployeeService;

/**
 * 
 * <p>
 * <b> Testes da permissao Service </b>
 * </p>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resource/service-application-context-test.xml" })
@Ignore
public class PermissionEmployeeServiceTest {

	/**
	 * Inicia service
	 */
	@Autowired
	private PermissionEmployeeService employeeService;
	
	/**
	 * Mocka dao
	 */
	@Mock
	private PermissionEmployeeDao permissionEmployeeDao;

	/**
	 * Seta dados antes de tudo iniciar
	 */
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);		
		employeeService.setDao(permissionEmployeeDao);
	}


	/**
	 * Testa criar permissao
	 */
	@Test
	@Transactional
	public void testeCriar() {
		PermissionEmployee permissionCriar = new PermissionEmployee();
		permissionCriar.setMatricula("teste");
		permissionCriar.setNome("Teste");
		PermissionEmployee permissionCriado = new PermissionEmployee();
		permissionCriado.setMatricula("teste");
		permissionCriado.setNome("Teste");
		permissionCriado.setId(1l);
		Mockito.when(permissionEmployeeDao.criar(permissionCriar)).thenReturn(
				permissionCriado);
		PermissionEmployee usuario = permissionEmployeeDao
				.criar(permissionCriar);
		Assert.assertNotNull(usuario);
		Assert.assertNotNull(usuario.getId());
	}

	/**
	 * Testa criar com atributo nulo
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testeCriarAtributoNulo() {
		PermissionEmployee permissionCriar = new PermissionEmployee();
		permissionCriar.setNome("Teste");
		permissionCriar.setMatricula("Test");
		employeeService.criar(null);
		employeeService.criar(permissionCriar);
	}

	/**
	 * Testa buscando com ID
	 */
	@Test
	public void testeBuscarPorId() {
		PermissionEmployee usuarioDaBusca = new PermissionEmployee();
		usuarioDaBusca.setId(1l);
		Mockito.when(permissionEmployeeDao.buscarPorId(1l)).thenReturn(
				usuarioDaBusca);

		PermissionEmployee usuario = employeeService.buscarPorId(1l);
		Assert.assertNotNull(usuario);

		usuario = employeeService.buscarPorId(2l);
		Assert.assertNull(usuario);
	}

	/**
	 * Testa  buscando com id inexistente
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testeBuscarPorIdInexistente() {
		PermissionEmployee usuario = employeeService.buscarPorId(2l);
		Assert.assertNull(usuario);
		Assert.assertNull(employeeService.buscarPorId(null));
	}

	/**
	 * Testa buscando por matricula
	 */
	@Test
	public void testeBuscarPorMatricula() {
		PermissionEmployee permissionDaBusca = new PermissionEmployee();
		permissionDaBusca.setMatricula("matricula");
		Mockito.when(permissionEmployeeDao.buscaPorMatricula("matricula"))
				.thenReturn(permissionDaBusca);
		PermissionEmployee permission = employeeService
				.buscaPorMatricula("matricula");
		Assert.assertNotNull(permission);
	}

	/**
	 * Testa busca por matricula inexistente
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testeBuscarPorMatriculaInexistente() {
		PermissionEmployee permission = employeeService
				.buscaPorMatricula("aoew");
		Assert.assertNull(permission);
		Assert.assertNull(employeeService.buscaPorMatricula(null));
	}

	/**
	 * Testa buscar todos
	 */
	@Test
	public void testeBuscarTodos() {
		PermissionEmployee permissionDaBusca = new PermissionEmployee();
		permissionDaBusca.setMatricula("matricula");
		List<PermissionEmployee> employeeList = new ArrayList<PermissionEmployee>();
		employeeList.add(permissionDaBusca);
		Mockito.when(permissionEmployeeDao.buscarTodos()).thenReturn(
				employeeList);
		List<PermissionEmployee> permissionList = employeeService.buscarTodos();
		Assert.assertTrue(permissionList.size() > 0);
	}

	/**
	 * Testa verifica acesso liberado
	 */
	@Test
	public void testeVerificarAcessoLiberado() {
		PermissionEmployee permissionDaBusca = new PermissionEmployee();
		permissionDaBusca.setMatricula("matricula");
		Mockito.when(permissionEmployeeDao.verificaAcesso("matricula"))
				.thenReturn(true);
	}

	/**
	 * Testa acesso nao liberado
	 */
	@Test
	public void testeVerificarAcessoNaoLiberado() {
		PermissionEmployee permissionDaBusca = new PermissionEmployee();
		permissionDaBusca.setMatricula("matricula1");
		Mockito.when(permissionEmployeeDao.verificaAcesso("matricula1"))
				.thenReturn(true);
	}

	/**
	 * Testa remover acesso
	 */
	@Test
	@Transactional
	public void testeRemoverAcesso() {
		permissionEmployeeDao.apagar(permissionEmployeeDao
				.buscaPorMatricula("matricula"));
		Assert.assertNull(permissionEmployeeDao.buscaPorMatricula("matricula"));
	}
	
	/**
	 * Testa remover acesso que nao existe
	 */
	@Test
	public void testeVerificarRemoverAcessoQueNaoExiste() {
		permissionEmployeeDao.apagar(permissionEmployeeDao
				.buscaPorMatricula("matricula1"));
	}

}
