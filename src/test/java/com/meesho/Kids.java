package com.meesho;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.ArrayList;
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

import com.meesho.rerun.RetryAnalyser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Kids {
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
public void launch_The_Application(@Optional("edge")String arg) {
		if(arg.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
	String url="https://www.meesho.com/";
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(url);
	String currentUrl=driver.getCurrentUrl();
	if(currentUrl.startsWith(url)) {
		System.out.println("Appclication Launched Successfully");
	}
	else {
		System.out.println("Appclication Launch Not Successful");	}

}
	@AfterClass(groups="Similar")
	public void close_The_Application() {
		driver.quit();
	}
	
	
	@Test(priority=2,groups="Click")
public void Click_On_KIDS() throws InterruptedException {
	try {
		WebElement Kids=driver.findElement(By.xpath("//span[text()=\'Kids\']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(Kids).perform();
		
}
	catch(Exception e) {
		e.printStackTrace();}
	}
	@Test(priority=3,groups="Click")
	public static void Click_SOftToys() throws InterruptedException  {
	try {
	WebElement SoftToys=driver.findElement(By.xpath("//p[text()=\'Soft Toys\']"));
	Actions ac=new Actions(driver);
	ac.moveToElement(SoftToys).build().perform();
	   Thread.sleep(2000);
    ac.click(SoftToys).build().perform();
	}catch(Exception e) {
		e.printStackTrace();}
	}

    @Test(priority=4,dataProvider="data",groups="Click")
    public void Validate_SoftToys_Page(String name) {
    	try {
	List<WebElement> lists=driver.findElements(By.xpath("//div[@class=\'NewProductCardstyled__ProductHeaderWrapper-sc-6y2tys-32 knWeEt\']"));
     for(int i=0;i<lists.size();i++) {
		WebElement list=lists.get(i);
		String text=list.getText();
		System.out.println(text);
		SoftAssert Soft=new SoftAssert();
	    Soft.assertEquals(text,name,"Assertion Failure in the WebElement text");
	    Soft.assertAll();
		if(text.equals(name)) {
			System.out.println("Text  matches with list : "+text);
		}
		else {
			System.out.println("Text not matches with list"+text);

		}
	}
    	}catch(Exception e) {
		e.printStackTrace();
	
    }
    }
}



