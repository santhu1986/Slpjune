package com.ebanking.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

public class Basicscript {
	
	public static void main(String[] args) 
	{
		String Expval="Ranford Bank";
		
		//firefox Browser
		
		WebDriver driver=new FirefoxDriver();
		
		//Maximise
		
		driver.manage().window().maximize();
		
		//URL
		
		driver.get("http://192.168.1.4/ranford2");
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
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
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
		
		Expval="Sucessfully";
		
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
		
		Actval=driver.switchTo().alert().getText();
		
		if (Actval.contains(Expval)) 
		{
			System.out.println("Branch created");
		}
		else
		{
			System.out.println("Branch Already Exist");
		}
		Sleeper.sleepTightInSeconds(5);	
		driver.switchTo().alert().accept();
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();

		
		
	}

}
