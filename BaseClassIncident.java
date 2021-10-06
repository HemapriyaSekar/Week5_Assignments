package week5.day1.Assignments;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassIncident {
	
	public ChromeDriver driver;
	public static String incidentNumber;
	public WebElement frame1;
	
	@Parameters({"url","username","password"})
	@BeforeMethod	
	public void PreCondition(String url, String uName, String pwd) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);		
		frame1 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("user_name")).sendKeys(uName);
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("filter")).sendKeys("Incidents");
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void PostCondition()
	{
		driver.close();
	}

}
