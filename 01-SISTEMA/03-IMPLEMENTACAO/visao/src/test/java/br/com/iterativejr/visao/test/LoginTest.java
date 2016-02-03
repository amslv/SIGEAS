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

	private static ChromeDriverService service;
	private WebDriver driver;

	@BeforeClass
	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(
						new File("src/test/resources/chromedriver"))
				.usingAnyFreePort().build();
		service.start();
	}

	@AfterClass
	public static void createAndStopService() {
		service.stop();
	}

	@Before
	public void createDriver() {
		driver = new RemoteWebDriver(service.getUrl(),
				DesiredCapabilities.chrome());
		driver.get("localhost:8080/SIGEAS/");
	}

	@After
	public void quitDriver() {
		driver.quit();
	}

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
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains(".xhtml"));
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
	}
	
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
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains(".xhtml"));
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
	}
	
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
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains(".xhtml"));
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
	}

	@Test
	@Ignore
	public void testLoginNotRegisteredInAcademicSystemAndNotNullPassword() {
		driver.findElement(By.id("j_username")).sendKeys("Login not registered");
		driver.findElement(By.id("j_password")).sendKeys("123456");		
		driver.findElement(By.id("input_enter")).click();
				
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		assertTrue(driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains("login"));
		assertEquals("http://localhost:8080/SIGEAS/loginFailure", driver.getCurrentUrl());
	}
	
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
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains(".xhtml"));
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
	}
	
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
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains(".xhtml"));
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
	}
	
	@Test
	@Ignore
	public void testLoginRegisteredInAcademicSystemButWrongPassword() {
		driver.findElement(By.id("j_username")).sendKeys("201225020360");
		driver.findElement(By.id("j_password")).sendKeys("123456");		
		driver.findElement(By.id("input_enter")).click();
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		assertTrue(driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains("login"));
		assertEquals("http://localhost:8080/SIGEAS/loginFailure", driver.getCurrentUrl());
	}

	@Test
	@Ignore
	public void testLoginNotRegisteredInSUAPAndNotNullPassword() {
		driver.findElement(By.id("j_username")).sendKeys("Login not registered");
		driver.findElement(By.id("j_password")).sendKeys("123456");
		driver.findElement(By.id("input_enter")).click();
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		assertTrue(driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains("login"));
		assertEquals("http://localhost:8080/SIGEAS/loginFailure", driver.getCurrentUrl());
	}
	
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
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains(".xhtml"));
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
	}
	
	@Test
	@Ignore
	public void testLoginRegisteredInSUAPButBlankPassword() {
		driver.findElement(By.id("j_username")).sendKeys("SUBSTITUIR POR LOGIN VÁLIDO");
		driver.findElement(By.id("j_password")).sendKeys("");		
		driver.findElement(By.id("input_enter")).click();
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		assertTrue(!driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains(".xhtml"));
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
	}
	
	@Test
	@Ignore
	public void testLoginRegisteredInSUAPButWrongPassword() {
		driver.findElement(By.id("j_username")).sendKeys("SUBSTITUIR POR LOGIN VÁLIDO");
		driver.findElement(By.id("j_password")).sendKeys("123456");
		driver.findElement(By.id("input_enter")).click();
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertTrue(!driver.findElement(By.id("alertInput")).getText().contains("Matrícula Inválida."));
		assertTrue(driver.findElement(By.id("alertInput")).getText().contains("Senha Inválida."));
		assertTrue(!driver.findElement(By.id("alertLogin")).getText().contains("Acesso Negado. Tente Novamente."));
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.urlContains(".xhtml"));
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
	}
	
	@Test
	@Ignore
	public void testLoginRegisteredInAcademicSystemAndCorrectPassword() {
		driver.findElement(By.id("j_username")).sendKeys("201225020360");
		driver.findElement(By.id("j_password")).sendKeys("456123");		
		driver.findElement(By.id("input_enter")).click();
		
		(new WebDriverWait(driver, 3)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equals("Menu");
            }
        });
		assertEquals("Inscrições", driver.findElement(By.id("cssmenu1")).getText());
		//Testar nome de perfil
		//Testar tipo de perfil
	}
	
	@Test
	@Ignore
	public void testLoginRegisteredInSUAPLikeFinancialOfficerAndCorrectPassword() {
		driver.findElement(By.id("j_username")).sendKeys("LOGIN REGISTERED");
		driver.findElement(By.id("j_password")).sendKeys("CORRECT PASSWORD");
		
		driver.findElement(By.id("input_enter")).click();
		
		(new WebDriverWait(driver, 3)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equals("Menu");
            }
        });
		assertTrue(driver.findElement(By.id("cssmenu2")).getText().contains("Pagamentos"));
		//Testar nome de perfil
		//Testar tipo de perfil
	}
	
	@Test
	@Ignore
	public void testLoginRegisteredInSUAPLikeAssistantAndCorrectPassword() {
		driver.findElement(By.id("j_username")).sendKeys("LOGIN REGISTERED");
		driver.findElement(By.id("j_password")).sendKeys("CORRECT PASSWORD");
		
		driver.findElement(By.id("input_enter")).click();
		
		(new WebDriverWait(driver, 3)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equals("Menu");
            }
        });
		assertTrue(driver.findElement(By.id("cssmenu")).getText().contains("Atividades"));
		assertTrue(driver.findElement(By.id("cssmenu")).getText().contains("Relatórios"));
		//Testar nome de perfil
		//Testar tipo de perfil
	}
}