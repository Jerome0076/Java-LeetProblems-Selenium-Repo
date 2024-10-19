package test.selenium.week4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SeleniumTestPractice3 extends ReusableClass{
	
	
	
	@Test (enabled=false)
	public void createLeadforCanpaign() throws InterruptedException
	{
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

    	//    	Click view All and click Sales from App Launcher
    	driver.findElement(By.xpath("//button[text()='View All']")).click();    	
    	Thread.sleep(2000);

//    	Click on  Campaigns 
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@data-label='Campaigns']")));

//    	Click Bootcamp link 
    	performWaitandClick(driver.findElement(By.xpath("(//table/tbody/tr[1]/th//a)[1]")));

//    	Click Add Leads
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@title='Add Leads']")));
    	
//    	Click on the Search filed and click New Lead
    	performWaitandClick(driver.findElement(By.xpath("//input[@role='combobox']")));
    	Thread.sleep(5000);
    	WebElement newLeadsButton = driver.findElement(By.xpath("//span[@title='New Lead']"));
//    	action.moveToElement(newLeadsButton).click().build().perform();
    	driver.executeScript("arguments[0].click()", newLeadsButton);
    	
//    	Pick Salutation as 'Mr.' 
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='New Lead']"))));
    	performWaitandClick(driver.findElement(By.xpath("//span[text()='Salutation']/following::a[1]")));
    	performWaitandClick(driver.findElement(By.xpath("//a[text()='Mr.']")));
    	
//    	Enter first name as <your First Name> 
    	driver.findElement(By.xpath("//span[text()='First Name']/following::input[1]")).sendKeys("Jerome");

//    	Enter last name as <your last name> 
    	driver.findElement(By.xpath("//span[text()='Last Name']/following::input[1]")).sendKeys("JKR");

//    	Enter company as 'TestLeaf' 
    	driver.findElement(By.xpath("(//span[text()='Company']/following::input[1])[2]")).sendKeys("TestLeaf");

//    	Click Save 
    	performWaitandClick(driver.findElement(By.xpath("//button[@title='Save']")));

//    	Click Next 
    	performWaitandClick(driver.findElement(By.xpath("//button[text()='Next']")));
    	
//    	Click Submit on the Add to Campaign pop up 
    	performWaitandClick(driver.findElement(By.xpath("//button[text()='Submit']")));

//    	verify the created Lead under Campaign 
//    	Navigate to Leads tab 
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@title='Leads']")));
    	
//    	Search for Lead with your Name  
    	performWaitandClick(driver.findElement(By.xpath("//input[@name='Lead-search-input']")));
    	driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys("Jerome");
    	driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys(Keys.ENTER);

//    	Expected Result: Lead should be created in Leads tab and associated to Campaign
    	Thread.sleep(5000);
    	String nameVerify = driver.findElement(By.xpath("(//table/tbody/tr[1]/th)[1]//a")).getText();
    		if(nameVerify.equals("Jerome JKR"))
    			{
    				System.out.println("Test Passed");
    			}
    		else
    		{
    			System.out.println("Test Failed");
    		}
	}
	
	@Test
	public void certificationsSortOrder() throws InterruptedException
	{
//		Click on the sliding icon until 'See System Status' is displayed.
//		Click on Get Started link
		boolean flag=true,temp;
		
		while (flag) {
			temp=driver.findElement(By.xpath("//span[text()='See System Status']")).isDisplayed();
			if(temp)
			{
				driver.findElement(By.xpath("//span[text()='See System Status']/following::button[1]")).click();
				flag=false;
			}
			else driver.findElement(By.xpath("//div[@class='rightScroll']/button")).click();
		}
		
		//Click confirm on the redirecting page and navigate to SalesForce Trust new Window.
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows= new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//button[@onclick='goAhead()']")).click();
		Thread.sleep(5000);

//		Click on the Compliance
		performWaitandJSClick(driver.findElement(By.xpath("//a[text()='Compliance']")));

//		Click on the Documents
		performWaitandJSClick(driver.findElement(By.xpath("//a[text()='Documents']")));

//		Click on the 'Name' to sort name in Ascending order
		boolean sort = true;
		while(sort) 
		{
			String sorting = driver.findElement(By.xpath("//table/thead/tr/th[contains(@aria-label,'Name')]")).getAttribute("aria-sort");
			if(!sorting.equals("ascending"))
			{
				performWaitandClick(driver.findElement(By.xpath("//table/thead/tr/th/span[text()='Name']")));
			}
			sorting = driver.findElement(By.xpath("//table/thead/tr/th[contains(@aria-label,'Name')]")).getAttribute("aria-sort");
			if(sorting.equals("ascending"))
			{
				sort = false;
			}			
		}

//		Verify the Documents are displayed in alphabetical order 
		List<WebElement> docNameListElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]/a"));
		Thread.sleep(2000);
		List<String> docNameList = new ArrayList<>();
		for(WebElement eachDoc : docNameListElements)
		{
			docNameList.add(eachDoc.getText());
		}
		System.out.println(docNameList);
		
		List<String> sortedDocNameList = new ArrayList<String>(docNameList);
		Collections.sort(sortedDocNameList,String.CASE_INSENSITIVE_ORDER);
		System.out.println(sortedDocNameList);
		Thread.sleep(2000);
		
//		Expected Result: The order should be in the alphabetical order  
		if(docNameList.equals(sortedDocNameList))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
	}

}
