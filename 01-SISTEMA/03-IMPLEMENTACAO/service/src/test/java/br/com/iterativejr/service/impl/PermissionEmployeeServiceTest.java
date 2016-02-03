package br.com.iterativejr.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Before;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resource/service-application-context-test.xml" })
public class PermissionEmployeeServiceTest {

	@Autowired
	private PermissionEmployeeService employeeService;
	
	@Mock
	private PermissionEmployeeDao permissionEmployeeDao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);		
		employeeService.setDao(permissionEmployeeDao);
	}


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

	@Test(expected = ConstraintViolationException.class)
	public void testeCriarAtributoNulo() {
		PermissionEmployee permissionCriar = new PermissionEmployee();
		permissionCriar.setNome("Teste");
		permissionCriar.setMatricula("Test");
		employeeService.criar(null);
		employeeService.criar(permissionCriar);
	}

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

	@Test(expected = ConstraintViolationException.class)
	public void testeBuscarPorIdInexistente() {
		PermissionEmployee usuario = employeeService.buscarPorId(2l);
		Assert.assertNull(usuario);
		Assert.assertNull(employeeService.buscarPorId(null));
	}

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

	@Test(expected = ConstraintViolationException.class)
	public void testeBuscarPorMatriculaInexistente() {
		PermissionEmployee permission = employeeService
				.buscaPorMatricula("aoew");
		Assert.assertNull(permission);
		Assert.assertNull(employeeService.buscaPorMatricula(null));
	}

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

	@Test
	public void testeVerificarAcessoLiberado() {
		PermissionEmployee permissionDaBusca = new PermissionEmployee();
		permissionDaBusca.setMatricula("matricula");
		Mockito.when(permissionEmployeeDao.verificaAcesso("matricula"))
				.thenReturn(true);
	}

	@Test
	public void testeVerificarAcessoNaoLiberado() {
		PermissionEmployee permissionDaBusca = new PermissionEmployee();
		permissionDaBusca.setMatricula("matricula1");
		Mockito.when(permissionEmployeeDao.verificaAcesso("matricula1"))
				.thenReturn(true);
	}

	@Test
	@Transactional
	public void testeRemoverAcesso() {
		permissionEmployeeDao.apagar(permissionEmployeeDao
				.buscaPorMatricula("matricula"));
		Assert.assertNull(permissionEmployeeDao.buscaPorMatricula("matricula"));
	}

	@Test
	public void testeVerificarRemoverAcessoQueNaoExiste() {
		permissionEmployeeDao.apagar(permissionEmployeeDao
				.buscaPorMatricula("matricula1"));
	}

}
