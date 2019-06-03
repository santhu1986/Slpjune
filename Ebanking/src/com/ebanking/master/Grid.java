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

public class Grid 
{
 
	DesiredCapabilities Cap=null;
	@Parameters("browser")
	@Test
	public void gd(String Br) throws MalformedURLException
	{
		if (Br.equalsIgnoreCase("firefox")) 
		{
			Cap=new DesiredCapabilities();
			Cap.setBrowserName("firefox");
			Cap.setPlatform(Platform.WINDOWS);
				
		}
		else if (Br.equalsIgnoreCase("chrome"))
		{
			Cap=new DesiredCapabilities();
			Cap.setBrowserName("chrome");
			Cap.setPlatform(Platform.ANY);
			
		}
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.168:4444/wd/hub"),Cap);

driver.manage().window().maximize();
driver.get("https://opensource-demo.orangehrmlive.com/");
Sleeper.sleepTightInSeconds(7);
driver.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys("Admin");
driver.findElement(By.id("txtPassword")).sendKeys("admin123");
driver.findElement(By.xpath(".//*[@id='btnLogin']")).click();
	

		/*//URL
		
		driver.get("http://192.168.1.4/ranford2");
		//String Actval=driver.findElement(By.xpath(".//*[@id='Form1']/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		
				
		
		
		String Tit=driver.getTitle();
		System.out.println(Tit);
		
		//Admin Login
		
		//Expval="Welcome to Admin";
		
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.xpath(".//*[@id='login']")).click();
		
		
		

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
		
		//Alert
		
		driver.switchTo().alert().accept();

*/	
	}
	
}
