package com.Crossword.Pages;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Crossword.ExcelUtility.Crossword_Excel;

public class AuthorAward_Crossword_Page 
{

	protected WebDriver driver;
	
	By award = By.xpath("//*[@id=\"nav-menu-915599\"]/ul/li[6]/a");
	By aboutTheAward = By.xpath("//*[@id=\"header\"]/div/div/div[2]/ul/li[2]/a");
	By arrowClick = By.xpath("/html/body/div[2]/section/div[2]/div[2]/div[2]/div/button[2]");
	By author = By.xpath("//*[@id=\"MultiCarousel2\"]/div/div[6]/div/p[1]");

	//To Launch Browser
	public void LaunchBrowser() throws IOException 
	{ 
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\Driver\\chromedriver.exe");	//Set path to chromedriver.exe
		driver = new ChromeDriver();	//create chrome instance
		driver.manage().window().maximize();	//To Maximize the window
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  //Time to wait
		driver.get("https://www.crossword.in/"); //Get the crossword url
		System.out.println(driver.getTitle());  //To get the title
		
		Crossword_Excel data = new Crossword_Excel();	//Create an object for excel  
		driver.findElement(By.linkText("Login")).click(); //Find Login Button
		driver.findElement(By.id("user_session_email")).sendKeys(data.excel_username(1)); //Find username and send username by excel sheet
		driver.findElement(By.id("user_session_password")).sendKeys(data.excel_password(1));	//Find password and send password by excel sheet
		driver.findElement(By.xpath("//*[@id=\"user_session_submit\"]")).click(); //Click the submit Button
	}
	
	//Award for authors 
	public void award_book() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(award).click(); //Find the Award and click
		
		Set<String> winHandles = driver.getWindowHandles(); //To Handle Multiple Windows
		System.out.println("The number of windows handles are " +winHandles.size());
		for(String winHandle:winHandles)
		{
			driver.switchTo().window(winHandle);
		}
		String title = driver.getTitle(); //To get the title
		System.out.println("The page title is : " +title);
		
		driver.findElement(aboutTheAward).click(); //Find and click the About the award button
		Thread.sleep(2000);
		
		driver.findElement(arrowClick).click();	//Find and click the Arrow in award page
		Thread.sleep(2000);
		
		driver.findElement(arrowClick).click();	//Find and click the Arrow in award page
		Thread.sleep(2000);
		
		driver.findElement(author).click();	//Find and click the Author
		Thread.sleep(2000);
		
		
		Set<String> winHandles2 = driver.getWindowHandles(); //set the window handles
		System.out.println("The number of windows handles are" +winHandles2.size());
		for(String winHandle2:winHandles2)
		{
			driver.switchTo().window(winHandle2);
			//driver.close();
		}
		
		
	}
		
	//To close the award page
	public void close_award() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();	//to close the browser
	}

	//To take screenshot
	public void screenshot(String path) throws IOException
	{
				   TakesScreenshot ts=(TakesScreenshot)driver;	//Create an object to take screenshot
				   File ScrFile=ts.getScreenshotAs(OutputType.FILE);	//File to create to store screenshot
				   FileUtils.copyFile(ScrFile,new File(path));	//copy file at destination					
		
	}
}
