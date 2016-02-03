package br.com.iterativejr.visao.test;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(BlockJUnit4ClassRunner.class)
public class LoginTest extends TestCase {

	/**
	 * Drive do Google Chorme
	 */
	private static ChromeDriverService service;
	
	/**
	 * 
	 */
	private WebDriver driver;

	/**
	 * Executado antes de qualquer método da classe
	 * @throws IOException
	 */
	@BeforeClass
	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(
						new File("/usr/local/share/chromedriver"))
				.usingAnyFreePort().build();
		service.start();
	}

	/**
	 * Executado depois de qualquer método da classe
	 * @throws IOException
	 */
	@AfterClass
	public static void createAndStopService() {
		service.stop();
	}

	/**
	 * Executado antes de todo método da classe
	 */
	@Before
	public void createDriver() {
		driver = new RemoteWebDriver(service.getUrl(),
				DesiredCapabilities.chrome());
		driver.get("localhost:8080/sigeas-visao/");
	}

	/**
	 * Executado após todo método da classe
	 */
	@After
	public void quitDriver() {
		driver.quit();
	}

	/**
	 * Teste com login e senha nulos
	 */
	@Test
	@Ignore
	public void testBlankLoginAndPasswordNotIsNull() {
		driver.findElement(By.id("j_username")).sendKeys("");
		driver.findElement(By.id("j_password")).sendKeys("Password Not Registered");		
		driver.findElement(By.id("input_enter")).click();
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		assertTrue(!driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		new WebDriverWait(driver, 3);
		assertEquals("http://localhost:8080/sigeas-visao/", driver.getCurrentUrl());
	}
	
	/**
	 * Teste com login e senha vazios
	 */
	@Test
	@Ignore
	public void testBlankLoginAndBlankPassword() {
		driver.findElement(By.id("j_username")).sendKeys("");
		driver.findElement(By.id("j_password")).sendKeys("");		
		driver.findElement(By.id("input_enter")).click();
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		assertTrue(!driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		new WebDriverWait(driver, 3);
		assertEquals("http://localhost:8080/sigeas-visao/", driver.getCurrentUrl());
	}
	
	/**
	 * Teste com login não registrado e senha vazia
	 */
	@Test
	@Ignore
	public void testLoginNotIsNullAndBlankPassword() {
		driver.findElement(By.id("j_username")).sendKeys("Login Not Registered");
		driver.findElement(By.id("j_password")).sendKeys("");		
		driver.findElement(By.id("input_enter")).click();
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		assertTrue(!driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		new WebDriverWait(driver, 3);
		assertEquals("http://localhost:8080/sigeas-visao/", driver.getCurrentUrl());
	}

	/**
	 * Teste com login não registrado e senha errada
	 */
	@Test
	@Ignore
	public void testLoginNotRegisteredInAcademicSystemAndNotNullPassword() {
		driver.findElement(By.id("j_username")).sendKeys("Login not registered");
		driver.findElement(By.id("j_password")).sendKeys("123456");		
		driver.findElement(By.id("input_enter")).click();
				
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		//assertTrue(driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		new WebDriverWait(driver, 5);
		assertEquals("http://localhost:8080/sigeas-visao/", driver.getCurrentUrl());
	}
	
	/**
	 * Teste com login não registrado e senha vazio
	 */
	@Test
	@Ignore
	public void testLoginNotRegisteredInAcademicSystemButBlankPassword() {
		driver.findElement(By.id("j_username")).sendKeys("Login not registered");
		driver.findElement(By.id("j_password")).sendKeys("");		
		driver.findElement(By.id("input_enter")).click();
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		assertTrue(!driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		new WebDriverWait(driver, 3);
		assertEquals("http://localhost:8080/sigeas-visao/", driver.getCurrentUrl());
	}
	
	/**
	 * Teste com login registrado em sistema acadêmico e senha vazia
	 */
	@Test
	@Ignore
	public void testLoginRegisteredInAcademicSystemButBlankPassword() {
		driver.findElement(By.id("j_username")).sendKeys("201225020360");
		driver.findElement(By.id("j_password")).sendKeys("");		
		driver.findElement(By.id("input_enter")).click();		
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		assertTrue(!driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		new WebDriverWait(driver, 3);
		assertEquals("http://localhost:8080/sigeas-visao/", driver.getCurrentUrl());
	}
	
	/**
	 * Teste com login registrado em sistema acadêmico e senha incorreta
	 */
	@Test
	@Ignore
	public void testLoginRegisteredInAcademicSystemButWrongPassword() {
		driver.findElement(By.id("j_username")).sendKeys("201225020360");
		driver.findElement(By.id("j_password")).sendKeys("123456");		
		driver.findElement(By.id("input_enter")).click();
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		//assertTrue(driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		new WebDriverWait(driver, 5);
		assertEquals("http://localhost:8080/sigeas-visao/", driver.getCurrentUrl());
	}

	/**
	 * Teste com login registrado em suap e senha incorreta
	 */
	@Test
	@Ignore
	public void testLoginNotRegisteredInSUAPAndNotNullPassword() {
		driver.findElement(By.id("j_username")).sendKeys("Login not registered");
		driver.findElement(By.id("j_password")).sendKeys("123456");
		driver.findElement(By.id("input_enter")).click();
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		//assertTrue(driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		new WebDriverWait(driver, 5);
		assertEquals("http://localhost:8080/sigeas-visao/", driver.getCurrentUrl());
	}
	
	/**
	 * Teste com login não registrado em suap e senha vazia
	 */
	@Test
	@Ignore
	public void testLoginNotRegisteredInSUAPButBlankPassword() {
		driver.findElement(By.id("j_username")).sendKeys("Login not registered");
		driver.findElement(By.id("j_password")).sendKeys("");
		driver.findElement(By.id("input_enter")).click();
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		assertTrue(!driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		new WebDriverWait(driver, 3);
		assertEquals("http://localhost:8080/sigeas-visao/", driver.getCurrentUrl());
	}
	
	/**
	 * Teste com login registrado em suap e senha vazia
	 */
	@Test
	@Ignore
	public void testLoginRegisteredInSUAPButBlankPassword() {
		driver.findElement(By.id("j_username")).sendKeys("ana");
		driver.findElement(By.id("j_password")).sendKeys("");		
		driver.findElement(By.id("input_enter")).click();
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		assertTrue(!driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		new WebDriverWait(driver, 3);
		assertEquals("http://localhost:8080/sigeas-visao/", driver.getCurrentUrl());
	}
	
	/**
	 * Teste com login não registrado em suap e senha errada
	 */
	@Test
	@Ignore
	public void testLoginRegisteredInSUAPButWrongPassword() {
		driver.findElement(By.id("j_username")).sendKeys("ana");
		driver.findElement(By.id("j_password")).sendKeys("123456");
		driver.findElement(By.id("input_enter")).click();
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		//assertTrue(driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		new WebDriverWait(driver, 5);
		assertEquals("http://localhost:8080/sigeas-visao/", driver.getCurrentUrl());
	}
	
	/**
	 * Teste com login registrado em sistema acadêmcico e senha correta
	 */
	@Test
	@Ignore
	public void testLoginRegisteredInAcademicSystemAndCorrectPassword() {
		driver.findElement(By.id("j_username")).sendKeys("jimi");
		driver.findElement(By.id("j_password")).sendKeys("123");		
		driver.findElement(By.id("input_enter")).click();
		
		(new WebDriverWait(driver, 3)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equals("Menu");
            }
        });
		assertEquals("Inscrições", driver.findElement(By.id("cssmenu1")).getText());
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains("student"));
		driver.get("localhost:8080/sigeas-visao/logout.xhtml");
	}
	
	/**
	 * Teste com login registrado em suap e senha correta
	 */
	@Test
	@Ignore
	public void testLoginRegisteredInSUAPLikeFinancialOfficerAndCorrectPassword() {
		driver.findElement(By.id("j_username")).sendKeys("gabi");
		driver.findElement(By.id("j_password")).sendKeys("123");
		
		driver.findElement(By.id("input_enter")).click();
		
		(new WebDriverWait(driver, 3)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equals("Menu");
            }
        });
		assertTrue(driver.findElement(By.id("cssmenu2")).getText().contains("Pagamentos"));
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains("financialWorker"));
		driver.get("localhost:8080/sigeas-visao/logout.xhtml");
	}
	
	/**
	 * Teste com login registrado em suap e senha correta
	 */
	@Test
	@Ignore
	public void testLoginRegisteredInSUAPLikeAssistantAndCorrectPassword() {
		driver.findElement(By.id("j_username")).sendKeys("ana");
		driver.findElement(By.id("j_password")).sendKeys("123");
		
		driver.findElement(By.id("input_enter")).click();
		
		(new WebDriverWait(driver, 3)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equals("Menu");
            }
        });
		assertTrue(driver.findElement(By.id("cssmenu")).getText().contains("Atividades"));
		assertTrue(driver.findElement(By.id("cssmenu")).getText().contains("Relatórios"));
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains("socialWorker"));
		driver.get("localhost:8080/sigeas-visao/logout.xhtml");
	}
}