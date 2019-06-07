package com.selenium.example;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.example.suport.Generator;
import com.selenium.example.suport.ScreenShot;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTest.csv")
public class InformacoesUsuarioTest {

	private WebDriver navegador;
	
	@Rule
	public TestName test = new TestName();

	@Before
	public void setup() {
		//Abrindo o navegador
		System.setProperty("webdriver.chrome.driver", "\\Users\\a.freitas.barbosa\\drivers\\chromedriver74.exe");
		navegador = new ChromeDriver();
		
		//tempo de espera implicito para esperar - 5 segundos de espera
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//abrindo página a ser testada
		navegador.get("http://www.juliodelima.com.br/taskit/");
		
		//clicar no link do texto "Sign in"
		WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
		linkSignIn.click();

		//Clicar no campo com name "login" que está dentro do formulário de id "signinbox"
		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));  

		//digitar no campo com name "login" que está dentro do formulário de ID "signinbox" o texto "julio001"
		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

		//digitar no campo name "password" que está dentro do formulário de id "signinbox" o texto "123456"
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

		//clicar no link com o texto "SING IN"
		navegador.findElement(By.linkText("SIGN IN")).click();

		//capiturar o texto de usuario logado que esta dentro do elemento com classe "me" está o texto "Hi, Julio"
		WebElement me = navegador.findElement(By.className("me"));
		// o getText pega o texto que está entre o abrir e fechar da tag
		String textoElementoMe = me.getText();

		//clicar no link que possui a classe "me"
		navegador.findElement(By.className("me")).click();
		//clicar no link que tem o "texto More data about you"
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
	}

	@Test
	public void addInformacoesDoUsuatioTest(@Param(name="tipo")String tipo, @Param(name = "contato")String contato, @Param(name="mensagem")String mensagem ) {

		//clicar no botão "add more data" através do seu xpath //button[@data-target="addmoredata"]
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

		//identificar o popup onde está o formulário id=addmoredata
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

		// na combo de name "type" escolher a opção "Phone"
		WebElement campoType = popupAddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText(tipo);

		//no campo de name "contact" digitar "+55819999999"
		popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

		//clicar no link de texto "SAVE" que está no popup 
		popupAddMoreData.findElement(By.linkText("SAVE")).click();

		// na mensagem de id "toast-container" validar se o texto é o "Your contact has been added!"
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagemToast = mensagemPop.getText();

		assertEquals(mensagem, mensagemToast);
	}
	
	//@Test
	public void removerContato() {
		//span[text()='+5590909']/following-sibling::a
		navegador.findElement(By.xpath("//span[text()=\"5511988991126\"]/following-sibling::a")).click();
		
		//confirmar a janela com javaScript
		navegador.switchTo().alert().accept();
		
		//valida que a mensagem apresentada foi  Rest in peace, dear phone!
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Rest in peace, dear phone!", mensagem);
		String screenshotArquivo = "/Desenvolvimento/screenshot" + Generator.dataHoraParaArquivo() + test.getMethodName() +  ".png";
		ScreenShot.tirar(navegador, screenshotArquivo);
		
		//aguardar até 10s para que a janela desaparaça (espera explícita) 
		WebDriverWait aguardar = new WebDriverWait(navegador, 10);
		aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
		
		navegador.findElement(By.linkText("Logout")).click();
	}

	@After
	public void testDown() {
		navegador.close();
	}
}
