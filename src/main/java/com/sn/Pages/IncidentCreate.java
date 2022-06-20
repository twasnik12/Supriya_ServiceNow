package com.sn.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sn.Commons.TestBase;

public class IncidentCreate extends TestBase{

	@FindBy(id = "sysverb_new")
	WebElement CreateNewIncident;
	
	@FindBy(id = "sys_display.incident.caller_id")
	WebElement caller;
	
	@FindBy (id = "incident.category")
	WebElement Category;
	
	@FindBy (id = "incident.subcategory")
	WebElement SubCategory;
	
	@FindBy(id = "sys_display.incident.business_service")
	WebElement Service;
	
	@FindBy(id = "sys_display.incident.service_offering")
	WebElement ServiceOffering;
	
	@FindBy(id = "sys_display.incident.cmdb_ci")
	WebElement ConfigurationItem;
	
	@FindBy(id = "incident.short_description")
	WebElement ShortDescription;

	@FindBy(id = "sysverb_insert_bottom")
	WebElement Submit;

	@FindBy(xpath ="//*[@id=\"list_nav_incident\"]/div/div[1]/h1/a")
	WebElement IncidentCreate;
	
	@FindBy(id = "incident.number")
	WebElement Incidentnumber;
	
	@FindBy(linkText = "Inquiry / Help")
	WebElement Incidentlink;
	
	@FindBy(xpath = "//*[@id=\"section-bf1d96e3c0a801640190725e63f8ac80.header\"]/nav/div/div[1]/button[2]")
	WebElement IncidentOptions;
	
	//@FindBy(linkText = "Create Child Incident")
	@FindBy(xpath = "//*[@id=\"context_1\"]/div[8]")
	WebElement CreateChildIncident;
	
	
	@FindBy(xpath = "//*[@id=\"tabs2_list\"]/span[4]/span/span[2]")
	WebElement Childincidenttab;
	
	//@FindBy(id = "sys_display.incident.caller_id")
	//WebElement ChildCallerid;
	
	//@FindBy(id = "incident.short_description")
	//WebElement childshortdescription;
	
	//@FindBy(id = "sysverb_insert_bottom")
	//WebElement ChildShortDescription;
	
	//@FindBy(linkText = "Inquiry / Help")
	//WebElement Incidentlink;
	//*[@id="a8e112491bc30510c527ed74604bcbcd_text"]
	//#b5dc5e0d1bc30510c527ed74604bcb64_text
	@FindBy(xpath = "/html/body/div[1]/div[1]/span/div/div[1]/div/span/div/div/input")
	WebElement Searchnumber;
	
	@FindBy(xpath = "//*[@id=\"output_messages\"]/div/div/span[2]")
	WebElement Incidenterrormsg;
	
	public IncidentCreate()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyIncidentPage()
	{
		return IncidentCreate.getText();	
	}
	
	public void ClickonNewButton() throws InterruptedException
	{
		driver.switchTo().frame("gsft_main");
		//Searchnumber.sendKeys("Searchnumber");
		CreateNewIncident.click();
		
	}
	
	public void CreateNewIncident(String Caller,String Shortdescription) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(Incidentnumber));
		//Thread.sleep(3000);
		String IncidentNo = Incidentnumber.getAttribute("value");
		System.out.println(IncidentNo);
		
		caller.clear();
		caller.sendKeys(Caller);
		caller.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
//		WebDriverWait wait1 = new WebDriverWait(driver, 3);
//		wait1.until(ExpectedConditions.visibilityOf(ShortDescription));
		ShortDescription.sendKeys(Shortdescription);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		wait2.until(ExpectedConditions.visibilityOf(Submit));
		//Thread.sleep(3000);
		Submit.click();
		//Thread.sleep(3000);
		System.out.println("Incident Created successfully");
//		String incidenterror = Incidenterrormsg.getText();
//		System.out.println("Error msg is:" +incidenterror );
		
		//Incidentlink.click();
		//System.out.println("Incident link clicked");
		//Thread.sleep(5000);
		
	}
	
	public void InvalidIncidentcreate(String Caller, String Shortdescription) throws InterruptedException
	{
		 
				String IncidentNo = Incidentnumber.getAttribute("value");
				System.out.println(IncidentNo);
				caller.clear();
				caller.sendKeys(Caller);
				WebDriverWait wait1 = new WebDriverWait(driver, 2);
				wait1.until(ExpectedConditions.elementSelectionStateToBe(caller, false));
				//Thread.sleep(1000);
				ShortDescription.sendKeys(Shortdescription);
				//Thread.sleep(3000);
				Submit.click();
				String incidenterror = Incidenterrormsg.getText();
				System.out.println("Error msg is:" +incidenterror );
				Assert.assertEquals(incidenterror, "The following mandatory fields are not filled in", "Test failed");
		
	}

	
	public void ClickonChildIncident() throws InterruptedException
	{
		System.out.println("Create child incident Test");
		//driver.switchTo().frame("gsft_main");
		Incidentlink.click();
	    System.out.println("Incident link clicked");
//	    WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.visibilityOf(IncidentOptions));
	    Thread.sleep(3000);
	    IncidentOptions.click();
	    System.out.println("Clicked on incident more options");
	    CreateChildIncident.click();
	    System.out.println("Clicked on Create child incident");
    }
	
	public void CreatechildIncident(String Caller,String childshortdescr) throws InterruptedException
	{
//		 WebDriverWait wait = new WebDriverWait(driver, 3);
//		 wait.until(ExpectedConditions.visibilityOf(Incidentnumber));
		Thread.sleep(3000);
		String ChildIncidentnum = Incidentnumber.getAttribute("value");
		System.out.println("The child incident is:" +ChildIncidentnum);
		
		//caller.clear();
		caller.sendKeys(Caller);
		//caller.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
//		WebDriverWait wait1 = new WebDriverWait(driver, 3);
//		wait1.until(ExpectedConditions.elementSelectionStateToBe(caller, false));
	//	Thread.sleep(2000);
		ShortDescription.sendKeys(childshortdescr);
		
		//Thread.sleep(3000);
		Submit.click();
		System.out.println("Child incident created successfully");
		Childincidenttab.click();
	}
	
	
	
}
