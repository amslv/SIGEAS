package br.edu.ifpb.sigeas.view.webapp;

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
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(BlockJUnit4ClassRunner.class)
public class LoginTest extends TestCase {

	private static ChromeDriverService service;
	private WebDriver driver;

	@BeforeClass
	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(
						new File("/usr/local/share/chromedriver"))
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
		driver.get("localhost:8080/SIGEAS/login.xhtml");
	}

	@After
	public void quitDriver() {
		driver.quit();
	}

	@Test
	@Ignore
	public void testBlankLoginAndPasswordNotIsNull() {
		driver.findElement(By.name("form-login:login")).sendKeys("");
		driver.findElement(By.name("form-login:password")).sendKeys("Password Not Registered");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
		new WebDriverWait(driver, 1);
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
		assertTrue(driver.findElement(By.className("ui-growl-message")).getText().contains("Login inválido"));
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Senha inválida"));
	}
	
	@Test
	public void testBlankLoginAndBlankPassword() {
		driver.findElement(By.name("form-login:login")).sendKeys("");
		driver.findElement(By.name("form-login:password")).sendKeys("");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
		new WebDriverWait(driver, 1);
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
		assertTrue(driver.findElement(By.className("ui-growl-message")).getText().contains("Login inválido"));
	}
	
	@Test
	@Ignore
	public void testLoginNotIsNullAndBlankPassword() {
		driver.findElement(By.name("form-login:login")).sendKeys("Login Not Registered");
		driver.findElement(By.name("form-login:password")).sendKeys("");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
		new WebDriverWait(driver, 1);
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Login inválido"));
		assertTrue(driver.findElement(By.className("ui-growl-message")).getText().contains("Senha inválida"));
	}

	@Test
	@Ignore
	public void testLoginNotRegisteredInAcademicSystemAndNotNullPassword() {
		driver.findElement(By.name("form-login:login")).sendKeys("Login not registered");
		driver.findElement(By.name("form-login:password")).sendKeys("123456");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
		new WebDriverWait(driver, 1);
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Login inválido"));
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Senha inválida"));
		assertTrue(driver.findElement(By.className("ui-growl-message")).getText().contains("Acesso Negado. Tente Novamente."));
	}
	
	@Test
	@Ignore
	public void testLoginNotRegisteredInAcademicSystemButBlankPassword() {
		driver.findElement(By.name("form-login:login")).sendKeys("Login not registered");
		driver.findElement(By.name("form-login:password")).sendKeys("");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
		new WebDriverWait(driver, 1);
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Login inválido"));
		assertTrue(driver.findElement(By.className("ui-growl-message")).getText().contains("Senha inválida"));
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Acesso Negado. Tente Novamente."));
	}
	
	@Test
	@Ignore
	public void testLoginRegisteredInAcademicSystemButBlankPassword() {
		driver.findElement(By.name("form-login:login")).sendKeys("201225020360");
		driver.findElement(By.name("form-login:password")).sendKeys("");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
		new WebDriverWait(driver, 1);
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Login inválido"));
		assertTrue(driver.findElement(By.className("ui-growl-message")).getText().contains("Senha inválida"));
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Acesso Negado. Tente Novamente."));
	}
	
	@Test
	@Ignore
	public void testLoginRegisteredInAcademicSystemButWrongPassword() {
		driver.findElement(By.name("form-login:login")).sendKeys("201225020360");
		driver.findElement(By.name("form-login:password")).sendKeys("123456");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
		new WebDriverWait(driver, 1);
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Login inválido"));
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Senha inválida"));
		assertTrue(driver.findElement(By.className("ui-growl-message")).getText().contains("Acesso Negado. Tente Novamente."));
	}

	@Test
	@Ignore
	public void testLoginNotRegisteredInSUAPAndNotNullPassword() {
		driver.findElement(By.name("form-login:login")).sendKeys("Login not registered");
		driver.findElement(By.name("form-login:password")).sendKeys("123456");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
		new WebDriverWait(driver, 1);
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Login inválido"));
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Senha inválida"));
		assertTrue(driver.findElement(By.className("ui-growl-message")).getText().contains("Acesso Negado. Tente Novamente."));
	}
	
	@Test
	@Ignore
	public void testLoginNotRegisteredInSUAPButBlankPassword() {
		driver.findElement(By.name("form-login:login")).sendKeys("Login not registered");
		driver.findElement(By.name("form-login:password")).sendKeys("");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
		new WebDriverWait(driver, 1);
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Login inválido"));
		assertTrue(driver.findElement(By.className("ui-growl-message")).getText().contains("Senha inválida"));
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Acesso Negado. Tente Novamente."));
	}
	
	@Test
	@Ignore
	public void testLoginRegisteredInSUAPButBlankPassword() {
		driver.findElement(By.name("form-login:login")).sendKeys("SUBSTITUIR POR LOGIN VÁLIDO");
		driver.findElement(By.name("form-login:password")).sendKeys("");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
		new WebDriverWait(driver, 1);
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Login inválido"));
		assertTrue(driver.findElement(By.className("ui-growl-message")).getText().contains("Senha inválida"));
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Acesso Negado. Tente Novamente."));
	}
	
	@Test
	@Ignore
	public void testLoginRegisteredInSUAPButWrongPassword() {
		driver.findElement(By.name("form-login:login")).sendKeys("SUBSTITUIR POR LOGIN VÁLIDO");
		driver.findElement(By.name("form-login:password")).sendKeys("123456");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
		new WebDriverWait(driver, 1);
		
		assertEquals("Entrar no SIGEAS", driver.getTitle());
		assertEquals("http://localhost:8080/SIGEAS/login.xhtml", driver.getCurrentUrl());
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Login inválido"));
		assertTrue(driver.findElement(By.className("ui-growl-message")).getText().contains("Senha inválida"));
		assertTrue(!driver.findElement(By.className("ui-growl-message")).getText().contains("Acesso Negado. Tente Novamente."));
	}
	
	@Test
	@Ignore
	public void testLoginRegisteredInAcademicSystemAndCorrectPassword() {
		driver.findElement(By.name("form-login:login")).sendKeys("201225020360");
		driver.findElement(By.name("form-login:password")).sendKeys("123456");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
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
		driver.findElement(By.name("form-login:login")).sendKeys("LOGIN REGISTERED");
		driver.findElement(By.name("form-login:password")).sendKeys("CORRECT PASSWORD");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
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
		driver.findElement(By.name("form-login:login")).sendKeys("LOGIN REGISTERED");
		driver.findElement(By.name("form-login:password")).sendKeys("CORRECT PASSWORD");
		
		driver.findElement(By.name("form-login:button-enter")).click();
		
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