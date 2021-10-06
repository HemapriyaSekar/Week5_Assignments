package week5.day1.Assignments;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UpdateIncident extends BaseClassIncident{
	
	@Test
	public void updateIncident() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNumber,Keys.ENTER);
		Thread.sleep(1000);
		
		frame1 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame1);	      
	    WebElement dropdown = driver.findElement(By.xpath("//select[@name='incident.urgency']")); 
	    System.out.println("Hello1");
	    Select drop1 = new Select(dropdown);
	    drop1.selectByIndex(0);
	    if(dropdown.getText().equals("1-High"))
	    	System.out.println("Priority set to High");
	    
	    dropdown = driver.findElement(By.id("incident.state"));
	    drop1 = new Select(dropdown);
	    drop1.selectByIndex(1);
	    
	    if(dropdown.getText().equals("In Progress"))
	    	System.out.println("Status set to In Progress");
	    
	    driver.findElement(By.id("activity-stream-work_notes-textarea")).sendKeys("text");
	    
	    driver.findElement(By.id("sysverb_update_bottom")).click();	    
	    
	}

	
}
