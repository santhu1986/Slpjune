package com.ebanking.master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grids 
{
DesiredCapabilities cap;
@Parameters("browser")
@Test
public void gd(String Br) throws MalformedURLException
{
	if (Br.equalsIgnoreCase("firefox")) 
	{
		cap=new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
			
	}
	else if (Br.equalsIgnoreCase("chrome"))
	{
		cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
			
	}
	
	
	RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.189:4444/wd/hub"),cap);

	//Maximise

	String Expval="Ranford Bank";
	driver.manage().window().maximize();
	
	//URL
	
	driver.get("http://183.82.100.55/ranford2");
	String Actval=driver.findElement(By.xpath(".//*[@id='Form1']/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
	
	if (Expval.equalsIgnoreCase(Actval))
	{
	System.out.println("Ranford Home Page Is Opened");	
	}
	else
	{
		System.out.println("Ranford Home Page Is Not Opened");
	}
	
	
	
	
	/*String Tit=driver.getTitle();
	System.out.println(Tit);*/
	
	//Admin Login
	
	Expval="Welcome to Admin";
	 
	driver.findElement(By.id("txtuId")).sendKeys("Admin");
	driver.findElement(By.id("txtPword")).sendKeys("M1ndq");
	driver.findElement(By.xpath(".//*[@id='login']")).click();
	
	Actval=driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
     
	if (Expval.equalsIgnoreCase(Actval))
	{
	System.out.println("Admin Home Page Is Opened");	
	}
	else
	{
		System.out.println("Admin Home Page Is Not Opened");
	}
	

	//Branches
	
	//Expval="Sucessfully";
	
	driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
	Sleeper.sleepTightInSeconds(5);
	driver.findElement(By.id("BtnNewBR")).click();
	
	driver.findElement(By.id("txtbName")).sendKeys("mindqsys12585");
	driver.findElement(By.id("txtAdd1")).sendKeys("karimnagar");
	driver.findElement(By.id("txtArea")).sendKeys("abcdef");
	driver.findElement(By.id("txtZip")).sendKeys("12345");
	Select ctry=new Select(driver.findElement(By.id("lst_counrtyU")));
	ctry.selectByVisibleText("INDIA");
	Sleeper.sleepTightInSeconds(5);
	Select state=new Select(driver.findElement(By.id("lst_stateI")));
	state.selectByVisibleText("GOA");
	Sleeper.sleepTightInSeconds(5);
	Select city=new Select(driver.findElement(By.id("lst_cityI")));
	city.selectByVisibleText("GOA");
	Sleeper.sleepTightInSeconds(5);
	driver.findElement(By.id("btn_insert")).click();
	




}
}
