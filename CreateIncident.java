package week5.day1.Assignments;
import java.util.List;

import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateIncident extends BaseClassIncident  {
	
	@Test
	public void createIncident() throws InterruptedException
	{
			
		frame1 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("sysverb_new")).click();
		driver.findElement(By.id("incident.short_description")).sendKeys("Incident creation from Java script");
		incidentNumber = driver.findElement(By.xpath("//input[@name='incident.number']")).getAttribute("value");		  
		System.out.println("incidentnumber: "+incidentNumber);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNumber,Keys.ENTER);
		Thread.sleep(1000);
		WebElement webTable = driver.findElement(By.id("incident_table"));
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
          
	    for (int i = 2; i < tableRows.size(); i++)
	    {
			WebElement webIndividualRow = tableRows.get(i);
			List<WebElement> findIndivColumn = webIndividualRow.findElements(By.tagName("td"));
			int columnSize = findIndivColumn.size();
			if (columnSize<=1)
			{
				System.out.println("Incident number not created/matched");
				return;
			}	  				
			String text = findIndivColumn.get(2).getText();
			System.out.println("Column2: "+text);
		    if(incidentNumber.equals(text))
		    {
		    	System.out.println("Incident number :"+text+" created successfully" );
		    	return;
		    }
  			
	    }
		
	}
	
}
