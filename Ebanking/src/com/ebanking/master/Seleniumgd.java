package com.ebanking.master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Seleniumgd 
{

	DesiredCapabilities cap=null;
	@Parameters("browser")
	@Test
	public void grid(String Br) throws MalformedURLException
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
		
        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.154:4444/wd/hub"),cap);
	

driver.manage().window().maximize();
driver.get("https://opensource-demo.orangehrmlive.com/");
Sleeper.sleepTightInSeconds(7);
driver.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys("Admin");
driver.findElement(By.id("txtPassword")).sendKeys("admin123");
driver.findElement(By.xpath(".//*[@id='btnLogin']")).click();
	
	
	
	
	}
}
