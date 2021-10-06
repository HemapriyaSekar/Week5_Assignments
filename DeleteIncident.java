package week5.day1.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseClassIncident{
	
	@Test
	public void deleteIncident() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNumber,Keys.ENTER);
		Thread.sleep(1000);
		
		frame1 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame1);	      
		Thread.sleep(1000);
		
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
	}

	
}
