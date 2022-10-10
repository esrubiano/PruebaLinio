package com.prueba.linio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinioTest {
	// CREAR OBJETO TIPO WEBDRIVER
	private WebDriver driver;
	
	//CREAR ANOTACIONES JUNIT
	@Before
	public void navegadorChrome()
	{
		//SETEAR LAS PROPIEDADES DEL EJECUTABLE DE CHROME
		System.setProperty("webdriver.chrome.driver","./src/test/resources/driver/chromedriver.exe");
		//DECLARAR EL OBJETO DRIVER TIPO CHROMEDRIVER
		driver = new ChromeDriver();	
		//MAXIMIZAR VENTANA DE NAVEGADOR
		driver.manage().window().maximize();
				
		//INGRESAR LA URL DE PAGINA DE ACCESO
		driver.get("https://www.linio.com.co/");
	}
	
	
	@Test
	public void iniciarPrueba() throws InterruptedException
	{
		//CREAR UN OBJETO DE LA PAGINA PRINCIPAL
		WebElement txtBusqueda = driver.findElement(By.xpath("//div/input[@class='form-control']"));
		//LIMPIAR LA CAJA DE TEXTO DE BUSQUEDA
		txtBusqueda.clear();
		//ENVIAR UN VALOR A BUSCAR
		txtBusqueda.sendKeys("Redmi Not");
		//ACEPTAR BUSQUEDA
		txtBusqueda.submit();
		//OBJETO PRODUCTO A SELECCIONAR
		WebElement imgProducto = driver.findElement(By.xpath("//div[@data-card-sku='XI310EL15S4GTLCO']/a[@class='col-12 pl-0 pr-0']"));
		//SELECCIONAR PRODUCTO
		imgProducto.click();
		//OBJETO BOTON AÑADIR AL CARRITO
		WebElement botonAnadir = driver.findElement(By.xpath("//div/button[@class='btn btn-lg buy-now-button btn-primary'][@id='buy-now']"));
		//CLICK AÑADIR AL CARRITO
		botonAnadir.click();
		//TIEMPO DE ESPERA PARA CARGA DE PAGINA
		Thread.sleep(1000);
		//OBJETO BOTON IR A CARRITO
		WebElement botonIrACarrito = driver.findElement(By.xpath("//div/a[@class='btn btn-sm btn-go-to-cart added-product']"));
		//CLICK BOTON IR A CARRITO
		botonIrACarrito.click();
		//TIEMPO DE ESPERA PARA MOSTRAR POPUP
		Thread.sleep(1000);
		//OBJETO BOTON PROCESAR COMPRA
		WebElement botonProcesar = driver.findElement(By.xpath("//li/a[@class='btn btn-lg btn-primary summary-btn-process-pay col-md-12'][contains(text(),'Procesar Compra')]"));
		//CLICK BOTON PROCESAR
		botonProcesar.click();
		//OBJETO PESTAÑA CREAR CUENTA
		WebElement tabCrearCuenta = driver.findElement(By.xpath("//li/a[contains(text(),'Crear cuenta')][@href='#register-form']"));
		//CLICK PESTAÑA
		tabCrearCuenta.click();
		//OBJETOS CAMPOS
		WebElement txtNombre = driver.findElement(By.xpath("//div/input[@id='registration_firstName']"));
		WebElement txtApellido = driver.findElement(By.xpath("//div/input[@id='registration_lastName']"));
		WebElement txtEmail = driver.findElement(By.xpath("//div/input[@id='registration_email']"));
		WebElement txtContraseña = driver.findElement(By.xpath("//div/input[@id='registration_password']"));
		WebElement txtCedula = driver.findElement(By.xpath("//div/input[@id='registration_nationalRegistrationNumber']"));
		//LIMPIAR CAMPO
		txtNombre.clear();
		//VALORES A COMPLETAR
		txtNombre.sendKeys("Alberto");
		txtApellido.clear();
		txtApellido.sendKeys("Rodriguez");
		txtEmail.clear();
		txtEmail.sendKeys("alberto@gmail.com");
		txtContraseña.clear();
		txtContraseña.sendKeys("j6@32#jfsd%%");
		txtCedula.clear();
		txtCedula.sendKeys("1010123456");
		//OBJETOS CHECKBOX
		WebElement checkDatos = driver.findElement(By.xpath("//label[@for='registration_acceptTerms']"));	
		WebElement checkCMR = driver.findElement(By.xpath("//label[@for='registration_cmrPointsAcceptedSubscription']"));
		//CLICK EN CHECKBOX
		checkDatos.click();
		checkCMR.click();
		//TIEMPO DE ESPERA PARA VALIDAR INFORMACION
		Thread.sleep(4000);	
				
	}
	
	
	@After
	public void cerrarNavegador()
	{
		driver.quit();
	}
	
}
