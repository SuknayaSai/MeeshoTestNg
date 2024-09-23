package com.meesho;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Electronics {
	@BeforeSuite(groups="Similar")
	public void beforeSuite() {
		System.out.println("BeforeSuite");
	}
	@AfterSuite(groups="Similar")
	public void afterSuite() {
		System.out.println("AfterSuite");
	}
	@BeforeTest(groups="Similar")
	public void beforeTest() {
		System.out.println("BeforeTest");
	}
	@AfterTest(groups="Similar")
	public void afterTest() {
		System.out.println("AfterTest");
	}
	static WebDriver driver;
	@DataProvider(name="data")
	public Object [][] dataName(){//[]--1Dimentional or 1d array,[][]-2dimentional or 2d array
    return new Object [][] {{"list"}};
		
	}
	@BeforeMethod(groups="Similar")
	public void before() {
		System.out.println("Before Method");
	}
	@AfterMethod(groups="Similar")
	public void after() {
		System.out.println("After Method");
	}
	@org.testng.annotations.Parameters({"browser"})
	@BeforeClass(groups="Similar")
public void Launch_The_Application(String arg) {
		try {
			if(arg.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
	String url="https://www.meesho.com";
	driver.navigate().to(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String currenturl=driver.getCurrentUrl();
	if(url.equals(currenturl)) {
		System.out.println("Application Launched Successfully");
	}
	else {
		System.out.println("Application Not Launched Successful");
	}}
	catch(Exception e){
		e.printStackTrace();
	}
		}
	@AfterClass(groups="Similar")
	public void close_The_Application() {
		driver.quit();
	}
	
	@Test(priority=2,groups="Move")
	public void  Move_To_Men() {
		try {

		WebElement Men=driver.findElement(By.xpath("//span[text()=\"Men\"]"));
		Actions ac=new Actions(driver);
		ac.moveToElement(Men).perform();}	
		catch(Exception e){
			e.printStackTrace();
		}

	}
	@org.testng.annotations.Parameters({"meesho","user"})

	@Test(priority=3,groups="Move")
	public void Click_On_Jewellery (@Optional("Jwels123")String arg,@Optional("user123") String arg1) throws InterruptedException {
		System.out.println(arg+" "+arg1);
		try {
		WebElement Watches=driver.findElement(By.xpath("//p[text()=\"Jewellery\"]"));
        Actions ac=new Actions(driver);
        ac.moveToElement(Watches).perform();
        Thread.sleep(2000);
        ac.click(Watches).perform();
	}
	catch(Exception e){
		e.printStackTrace();
	}}
	@Test(priority=4,dataProvider="data")
    public void Validate_Wateches_page(String name) {
    	try {
    		List<WebElement>lists=driver.findElements(By.xpath("//div[@class=\"NewProductCardstyled__ProductHeaderWrapper-sc-6y2tys-32 knWeEt\"]"));
    		for(int i=0;i<lists.size();i++) {
    			String text=lists.get(i).getText();
    			SoftAssert Soft=new SoftAssert();
    		    Soft.assertEquals(name,"Assertion Failure in the WebElement text");
    		    Soft.assertAll();
    			if(text.equals(name)) {
    				System.out.println("list matches with lists:"+text);
    			}
    			else {
    				System.out.println("list not matches with lists:"+text);
    		}}
    	}catch(Exception e) {
		e.printStackTrace();
	
    }
    }
	
	
	
	
	
	
	
}
