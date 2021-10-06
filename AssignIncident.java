package week5.day1.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AssignIncident extends BaseClassIncident{
	
	@Test
	public void assignIncident() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNumber,Keys.ENTER);
		Thread.sleep(1000);
		
		frame1 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame1);	      
		Thread.sleep(1000);
		/*
		 * WebElement webTable = driver.findElement(By.id("incident_table"));
		 * List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		 * 
		 * for (int i = 2; i < tableRows.size(); i++) { WebElement webIndividualRow =
		 * tableRows.get(i); List<WebElement> findIndivColumn =
		 * webIndividualRow.findElements(By.tagName("td")); int columnSize =
		 * findIndivColumn.size(); if (columnSize<=1) {
		 * System.out.println("Incident number not matched"); return; } String text =
		 * findIndivColumn.get(2).getText(); System.out.println("Column2: "+text);
		 * if(incidentNumber.equals(text)) { findIndivColumn.get(2).click(); return; }
		 * 
		 * }
		 */
	    
	    driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']")).click();
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> name = new ArrayList<String>(windowHandles);
	    driver.switchTo().window(name.get(1));
	    driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Software",Keys.ENTER);
	    WebElement webtable = driver.findElement(By.id("sys_user_group_table"));
	    List<WebElement> tableRow = webtable.findElements(By.tagName("tr"));
	    System.out.println("Table Row: "+tableRow.size());
	    for (WebElement webElement : tableRow) {
	    	if(webElement.getText().equals("Software"))
	    	{
	    		System.out.println("Click Software");	    		
    			webElement.click();
    			driver.switchTo().window(name.get(0));
    			return;
	    	}
			
		}
	    driver.findElement(By.id("activity-stream-textarea")).sendKeys("text");
	    
	    driver.findElement(By.id("sysverb_update_bottom")).click();	       
	    
	    
	}

	
}
