package practica;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class E2ETest {

	@Test
	public void methodOne () throws InterruptedException {	
		
	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://rahulshettyacademy.com/client");
	
	driver.findElement(By.id("userEmail")).click();
	driver.findElement(By.id("userEmail")).sendKeys("abc8@gmail.com");	
	driver.findElement(By.id("userPassword")).click();
	driver.findElement(By.id("userPassword")).sendKeys("AbecedarB1*.");
	driver.findElement(By.id("login")).submit();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='container']//div[1]//div[1]//div[1]//button[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/app-sidebar[1]/nav[1]/ul[1]/li[4]/button[1]")).click();

	driver.findElement(By.xpath("//button[contains(text(),'Buy Now')]")).click();
	Thread.sleep(3000);
	
	WebElement element = driver.findElement(By.xpath("//body/app-root[1]/app-order[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/input[1]"));
	element.click();
	element.sendKeys("Moldova, Republic of");
	driver.findElement(By.xpath("//body/app-root[1]/app-order[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/section[1]/button[1]/span[1]")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//body/app-root[1]/app-order[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[2]/a[1]")).click();
	
	Thread.sleep(3000);	
	WebElement orderNumberElement = driver.findElement(By.xpath("//label[contains(@class, 'ng-star-inserted')]"));
	String orderNumber = orderNumberElement.getText();
	String extractedNumber = orderNumber.replaceAll("[  | |  ]", "");
	System.out.println(extractedNumber);
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//body/app-root[1]/app-thanksorder[1]/app-sidebar[1]/nav[1]/ul[1]/li[3]/button[1]")).click();
	
	WebElement expectedNumber = driver.findElement(By.cssSelector("app-myorders.ng-star-inserted:nth-child(2) div.container.table-responsive.py-5:nth-child(2) table.table.table-bordered.table-hover.ng-star-inserted:nth-child(2) tbody:nth-child(2) tr.ng-star-inserted > th:nth-child(1)"));
	String orderExpected = expectedNumber.getText();
	System.out.println(orderExpected);
	
	extractedNumber.equals(orderExpected);
	System.out.println(extractedNumber.equals(orderExpected));	
	assertEquals(extractedNumber, orderExpected);
	driver.quit();
	}
}


