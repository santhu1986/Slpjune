package com.ebanking.master;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;


public class Library 
{

		public static WebDriver driver;
		public static String Expval,Actval;
		public static FileInputStream Fis;
		public static Properties PR;
		
		
		public String OpenApp(String Url) throws IOException
	{
			Fis=new FileInputStream("E:\\AftnOct\\Ebanking\\src\\com\\ebanking\\properties\\Rep.properties");
			PR=new Properties();
			PR.load(Fis);
		Expval="Ranford Bank";
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		String Actval=driver.findElement(By.xpath(PR.getProperty("Rbank"))).getText();
		if (Expval.equalsIgnoreCase(Actval)) 
		{
			System.out.println("Ranford home page is displayed");
		}
		else
		{
			System.out.println("Ranford home page is not displayed");
		}
		return "Pass";
	}

	public void AdminLgn(String Un,String Pwd)
	{
		Expval="Welcome to Admin";
		driver.findElement(By.id(PR.getProperty("Uname"))).sendKeys(Un);
		driver.findElement(By.id(PR.getProperty("Pswd"))).sendKeys(Pwd);
		driver.findElement(By.xpath(PR.getProperty("Lgn"))).click();
		Actval=driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		System.out.println(Actval);
		if (Expval.equalsIgnoreCase(Actval))
		{
		System.out.println("Admin Home is displayed");	
		}
		else
		{
			System.out.println("Admin home page is not displayed");
		}

	}
	
	public String Branch(String bname,String add,String area,String zc,String ctr,String Sta,String cty)
	{

        Expval="Sucessfully";		
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.id("BtnNewBR")).click();
		driver.findElement(By.id("txtbName")).sendKeys(bname);
		driver.findElement(By.id("txtAdd1")).sendKeys(add);
		driver.findElement(By.id("txtArea")).sendKeys(area);
		driver.findElement(By.id("txtZip")).sendKeys(zc);
		Select ctry=new Select(driver.findElement(By.id("lst_counrtyU")));
		ctry.selectByVisibleText(ctr);
		Sleeper.sleepTightInSeconds(5);
		Select state=new Select(driver.findElement(By.id("lst_stateI")));
		state.selectByVisibleText(Sta);
		Sleeper.sleepTightInSeconds(5);
		Select city=new Select(driver.findElement(By.id("lst_cityI")));
		city.selectByVisibleText(cty);
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.id("btn_insert")).click();
		Sleeper.sleepTightInSeconds(4);
		//Alert
		Actval=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();
		if(Actval.contains(Expval))
		{
		System.out.println("Branch created Succ");	
           return "Branch Created";
		}
		else
		{
			System.out.println("Branch Already Exist");
			return "Branch exist";
		}
}


	public String RoleCre(String Rn,String Rd,String Rt)
	{
		Sleeper.sleepTightInSeconds(5);
		Expval="Sucessfully";
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		Sleeper.sleepTightInSeconds(4);
		driver.findElement(By.id("btnRoles")).click();
		driver.findElement(By.id("txtRname")).sendKeys(Rn);
		driver.findElement(By.id("txtRDesc")).sendKeys(Rd);
		Select rt=new Select(driver.findElement(By.id("lstRtypeN")));
		rt.selectByVisibleText(Rt);
		driver.findElement(By.id("btninsert")).click();
		Actval=driver.switchTo().alert().getText();
	Sleeper.sleepTightInSeconds(5);
		driver.switchTo().alert().accept();
	    driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();
		if (Actval.contains(Expval)) 
		{
			System.out.println("Role Craeted");
			}
		else
		{
			System.out.println("Role Already Exist");
		}
		return Actval;
	}

	public void admlgt()

	{
		Sleeper.sleepTightInSeconds(5);
		 driver.findElement(By.xpath(".//*[@id='Table_02']/tbody/tr/td[3]/a/img")).click();
		 
		 }

	public void Appc()
	{
		 driver.close();
	}


	//Role
	//Employee
	//Log out
	//Close
	}

