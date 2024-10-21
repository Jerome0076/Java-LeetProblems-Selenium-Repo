package test.selenium.week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTestPractice extends ReusableClass{

//    public static void main(String[] args) throws InterruptedException {
//
//        ChromeDriver driver = new ChromeDriver();
//        // Open Google homepage
//        driver.get("https://login.salesforce.com/");
//        Thread.sleep(8000);
//        // Close the browser after testing
//        driver.quit();
//    }
//	ChromeDriver driver;
//	WebDriverWait wait;
	
    
//    @BeforeSuite
//    public void initializeBrowserAndLogin()
//    {
//    	//Initialize Driver and Start App
//    	ChromeOptions options = new ChromeOptions();       
//        // Add argument to disable notifications
//        options.addArguments("--disable-notifications");
//    	driver = new ChromeDriver(options);
//    	driver.get("https://login.salesforce.com/");
//    	driver.manage().window().maximize();
//    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
////    }
////    
////    	@BeforeTest
////    public void login() {
//    	//    	Step 1: Login to Login | Salesforce  
//    	String username = "gokul.sekar@testleaf.com";
//    	String password = "Leaf$321";
//    	driver.findElement(By.id("username")).sendKeys(username);
//    	driver.findElement(By.id("password")).sendKeys(password);
//    	driver.findElement(By.id("Login")).click();
//    	wait = new WebDriverWait(driver, Duration.ofSeconds(25));
//    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='App Launcher']"))));
//    }
    
    @Test(enabled=true)
    public void testCreateAccount()
    {
    	//    	Click on toggle menu button from the left corner
    	driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

    	//    	Click view All and click Sales from App Launcher
    	driver.findElement(By.xpath("//button[text()='View All']")).click();
    	driver.findElement(By.xpath("//a//p[text()='Sales']")).click();
    	
    	//    	Click on Accounts tab 
    	WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
    	driver.executeScript("arguments[0].click()", eleAccounts);
    	   	
    	//    	Click on New button
    	driver.findElement(By.xpath("//a[@title='New']")).click();

    	//    	Enter 'your name' as account name
    	driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys("Jerome");
    	
    	//    	Select Ownership as Public 
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Ownership']/following::button")));
    	driver.findElement(By.xpath("//label[text()='Ownership']/following::button")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Public']")));
    	driver.findElement(By.xpath("//span[@title='Public']")).click();
    	
    	//    	Click save and verify Account name
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@name='SaveEdit']"))));
    	driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

    	//    	Expected Result:
    	//    	Account should be created Successfully
    	String expectedResult = driver.findElement(By.xpath("//div[@role=\"alert\"]/div//span[contains(@class,'toastMessage')]")).getText();
    	String expectedAccountName = driver.findElement(By.xpath("//div[@role=\"alert\"]/div//span[contains(@class,'toastMessage')]/a")).getAttribute("title");
    	System.out.println("Log : "+expectedResult+" : "+expectedAccountName+" is Created");
    }
    
    @Test (enabled=false)
    public void verifySorted() throws InterruptedException {
    	//    	Click on toggle menu button from the left corner
    	driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

    	//    	Click view All and click Sales from App Launcher
    	driver.findElement(By.xpath("//button[text()='View All']")).click();
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a//p[text()='Sales']"))));
    	driver.findElement(By.xpath("//a//p[text()='Sales']")).click();
    	
    	//    	Click on Accounts tab
    	WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
    	wait.until(ExpectedConditions.visibilityOf(eleAccounts));
    	driver.executeScript("arguments[0].click()", eleAccounts);
    	
    	
    	String currentSort;
    	currentSort = driver.findElement(By.xpath("//span[@title='Account Name']/parent::a/following-sibling::span")).getText();
    	String Sort = "Ascending";
    	if(!currentSort.contains(Sort))
    	{
    		
    		driver.findElement(By.xpath("//span[@title='Account Name']/parent::a")).click();
    		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//span[@title='Account Name']/parent::a/following-sibling::span")), Sort));
    		currentSort = driver.findElement(By.xpath("//span[@title='Account Name']/parent::a/following-sibling::span")).getText();
    		if(currentSort.contains(Sort)) {
    		System.out.println("Current Sort is "+currentSort);
    		}
    	}   
    	// Table Handling
    	Thread.sleep(5000);
    	wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//table/tbody/tr/th//a[@data-refid='recordId']"))));
    	Thread.sleep(5000);
    	List<WebElement> accountNames = driver.findElements(By.xpath("//table/tbody/tr/th//a[@data-refid='recordId']"));
    	int actualCountSize = accountNames.size();
    	int totalCountSize = 0;
    	Actions action = new Actions(driver);
    	
    	//Scroll till End
    	while(actualCountSize > totalCountSize) {
    		totalCountSize = actualCountSize;
    		action.moveToElement(accountNames.get(accountNames.size()-1)).perform();
    		accountNames = driver.findElements(By.xpath("//table/tbody/tr/th//a[@data-refid='recordId']"));
    		actualCountSize = accountNames.size();
    		action.moveToElement(accountNames.get(accountNames.size()-1)).perform();
    	}
    	
    	//Iterate and get all text
    	List<String> accountNameText = new ArrayList<String>();
    	for(WebElement textElement : accountNames) {
    		accountNameText.add(textElement.getText());	
    		action.moveToElement(accountNames.get(accountNames.size()-1)).perform();
    	}
    	System.out.println(accountNameText);
    	List<String> sortedAccountNameText = new ArrayList<String>(accountNameText);
    	Collections.sort(sortedAccountNameText,String.CASE_INSENSITIVE_ORDER);
    	System.out.println(sortedAccountNameText);
    	
    	if(accountNameText.equals(sortedAccountNameText))
    	{
    		System.out.println("PASS : Verified Account Name is sorted in Ascending Order");
    	}
    	else 
    	{
    		System.out.println("FAIL : Account Name is not sorted in Ascending Order");	
    	}
    }
    
    @Test (enabled=false)
    public void verifyCreateCase() throws InterruptedException {
    	//    	Click on toggle menu button from the left corner
    	driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

    	//    	Click view All and click Sales from App Launcher
    	driver.findElement(By.xpath("//button[text()='View All']")).click();    	
    	performWaitandClick(driver.findElement(By.xpath("//a//p[text()='Sales']")));
    	
    	//Click More Button
    	performWaitandClick(driver.findElement(By.xpath("//span[text()='More']")));
    	
    	//    	Click on Cases Option
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@role='menuitem']/span/span[text()='Cases']")));
    	
    	//    	Click on New Case
    	performWaitandClick(driver.findElement(By.xpath("//a[@role='button']/div[text()='New']")));
    	 	
    	//Verify New Case Window
    	String newCaseHeading = driver.findElement(By.xpath("//h2[text()='New Case']")).getText();
    	Assert.assertEquals("New Case", newCaseHeading);
    	
    	//    	Choose Contact Name from the dropdown
    	chooseContacts("Singam");  	
    	
		//    	Select Case origin as email
    	performWaitandClick(driver.findElement(By.xpath("//label[text()='Case Origin']/following-sibling::div//button")));
    	performWaitandClick(driver.findElement(By.xpath("//span[@title='Email']/parent::span")));
		
    	//    	Select status as Escalated
    	performWaitandClick(driver.findElement(By.xpath("//label[text()='Status']/following-sibling::div//button")));
    	performWaitandClick(driver.findElement(By.xpath("//span[@title='Escalated']/parent::span")));
    	
		//    	Enter Subject as 'Testing' and description as 'Dummy'
    	driver.findElement(By.xpath("//label[text()='Subject']/following-sibling::div//input")).sendKeys("Testing");
    	driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div//textarea")).sendKeys("Dummy");
    	 	
		//    	Click 'Save' and verify the message
    	performWaitandClick(driver.findElement(By.xpath("//button[@name='SaveEdit']")));
    }
    
    @Test (enabled=false)
    public void deleteOpurtunity() throws InterruptedException
    {
    	driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

    	//    	Click view All and click Sales from App Launcher
    	driver.findElement(By.xpath("//button[text()='View All']")).click();    	
    	performWaitandClick(driver.findElement(By.xpath("//a//p[text()='Sales']")));
    	
    	//Click Opportunities Button
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@title='Opportunities']")));
    	
    	//Search the Opportunity 'Salesforce Automation by *Your Name*' 
    	driver.findElement(By.xpath("//div[@type='search']/input[@type='search']")).sendKeys("Salesforce Automation by Gokul");
    	Thread.sleep(2000);   	
    	driver.findElement(By.xpath("//div[@type='search']/input[@type='search']")).sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
    	Actions actions = new Actions(driver);
    	actions.moveToElement(driver.findElement(By.xpath("//span[@role='status']"))).click().perform();
    	Thread.sleep(2000);
    	String valueBeforeDeletion = driver.findElement(By.xpath("//span[@role='status']")).getText();
    	String[] str = valueBeforeDeletion.split(" ");
    	int numBefore = Integer.parseInt(str[0]);
    	
    	//Click on the Dropdown icon and Select Delete 
    	performWaitandJSClick(driver.findElement(By.xpath("//table/tbody/tr[1]//span[contains(text(),'Show Actions')]/parent::*/parent::a")));
    	performWaitandJSClick(driver.findElement(By.xpath("//div[@role='menu']/ul/li/a[@title='Delete']")));
    	performWaitandClick(driver.findElement(By.xpath("//button[@title='Delete']")));
    	
    	//
    	Thread.sleep(3000);
    	String valueAfterDeletion = driver.findElement(By.xpath("//span[@role='status']")).getText();
    	String[] str1 = valueAfterDeletion.split(" ");
    	int numAfter = Integer.parseInt(str1[0]);
    	
    	if(numBefore-1 == numAfter) {
    		System.out.println("Test Passed");
    	}
    }	
    
	@Test (enabled=false)
	public void createLegalEntity() throws InterruptedException 
	{
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

    	//    	Click view All and click Sales from App Launcher
    	driver.findElement(By.xpath("//button[text()='View All']")).click();    	
    	Thread.sleep(2000);
    	
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@data-label='Legal Entities']")));
    	
    	performWaitandJSClick(driver.findElement(By.xpath("(//a[contains(@title,'Legal Entities')]/following::one-app-nav-bar-item-dropdown//a[@role='button'])[2]")));
	
    	performWaitandJSClick(driver.findElement(By.xpath("//span[text()='New Legal Entity']/ancestor::a")));
    	
    	//      Salesforce Automation by Jerome  
    	String legalEntityName = "Salesforce Automation by Manoj";
    	driver.findElement(By.xpath("//label[text()='Legal Entity Name']/following-sibling::div/input")).sendKeys(legalEntityName);
    	
    	performWaitandClick(driver.findElement(By.xpath("//button[@name='SaveEdit']")));
    	Thread.sleep(5000);
    	String expectedName = driver.findElement(By.xpath("//h1/slot/lightning-formatted-text[@slot='primaryField']")).getText();
    	
    	if(expectedName.equals(legalEntityName))
    	{
    		System.out.println("Test Passed : Legal Entity is Created");
    	}
    	else
    	{
    		System.out.println("Test Failed");
    	}
	}
    	
    @Test (enabled=false)
    public void editDashboard() throws InterruptedException
    {
    	driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

    	//    	Click view All and click Sales from App Launcher
    	driver.findElement(By.xpath("//button[text()='View All']")).click();    	
    	Thread.sleep(2000);
    	
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@data-label='Dashboards']")));
    	
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@title='Dashboards']")));
    	Thread.sleep(2000);
    	
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following-sibling::div/div/input"))));
    	
    	String searchStr = "Automation by Ilangovan";
    	
    	driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following-sibling::div/div/input")).sendKeys(searchStr);
    	
    	driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following-sibling::div/div/input")).sendKeys(Keys.ENTER);
    	
    	Thread.sleep(5000);
    	performWaitandJSClick(driver.findElement(By.xpath("//table/tbody/tr[1]//span[contains(text(),'Show actions')]/parent::button")));
    	performWaitandJSClick(driver.findElement(By.xpath("//span[text()='Edit']/parent::a")));
    	
    	Thread.sleep(15000);
    	
//    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']"))));
    	driver.switchTo().frame(0);
    	
    	performWaitandJSClick(driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")));
    	
    	String editedName = "SalesForce Automation by Ilangovan";
    	
    	driver.findElement(By.xpath("//label[text()='Name']/following::input[@id='dashboardNameInput']")).clear();
    	
    	driver.findElement(By.xpath("//label[text()='Name']/following::input[@id='dashboardNameInput']")).sendKeys(editedName);
    	
    	performWaitandClick(driver.findElement(By.xpath("//footer/button[text()='Save']")));
    	
    	String updatedName = driver.findElement(By.xpath("//button/span[text()='Edit Dashboard name']/ancestor::span")).getText();
    	
    	if(updatedName.contains(editedName))
    		{
    		System.out.println("Test Passed");
    		}
    	else
    	{
    		System.out.println("Test Failed");
    	}
    	
    	performWaitandClick(driver.findElement(By.xpath("//button[text()='Done']")));
    	
    	performWaitandClick(driver.findElement(By.xpath("//footer/button[text()='Save']")));
    	
    	String verifyText = driver.findElement(By.xpath("//h1/span[contains(text(),'"+editedName+"')]")).getText();
    	
    	if(verifyText.contains(editedName))
		{
		System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
    	
    }
   
    
//    @AfterTest
//    public void TearDownStep()
//    {	
//    	driver.quit();
//    }
//    
    
}
