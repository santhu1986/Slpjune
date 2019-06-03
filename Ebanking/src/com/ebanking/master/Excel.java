package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel 
{   @Test
	public void ex() throws IOException 
	{
         Library Lb=new Library();
         
         Lb.OpenApp("http://183.82.100.55/ranford2");
         Lb.AdminLgn("Admin","Admin");
         
         FileInputStream Fis=new FileInputStream("E:\\AftnOct\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
         
         //WorkBook
         
         XSSFWorkbook WB=new XSSFWorkbook(Fis);
         
         //Sheet
         
         XSSFSheet WS=WB.getSheet("Rdata");
         
         //Row Count
         
         int Rcount=WS.getLastRowNum();
         System.out.println(Rcount);
         
         //Multiple Iterations ---- For Loop
         
         for (int i=1;i<=Rcount;i++) 
         {
        	 //Row
        	 
        	 XSSFRow WR=WS.getRow(i);
        	 
        	 //Cells
        	 
        	 XSSFCell WC=WR.getCell(0);
         	 XSSFCell WC1=WR.getCell(1);
         	 XSSFCell WC2=WR.getCell(2);
			
         	 XSSFCell WC3=WR.createCell(3);
         	 
         	//Cell Values
         	 
         	 String Rname=WC.getStringCellValue();
         	 String Rdes=WC1.getStringCellValue();
         	 String Rtyp=WC2.getStringCellValue();
         	 
         	 String Res=Lb.RoleCre(Rname,Rdes,Rtyp);
         	 WC3.setCellValue(Res);
         	 
         	 }

         
         //Results
         
       FileOutputStream Fos=new FileOutputStream("E:\\AftnOct\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.xlsx");  
       WB.write(Fos);
       WB.close();
         
         
         
         
         
         
	}

}
