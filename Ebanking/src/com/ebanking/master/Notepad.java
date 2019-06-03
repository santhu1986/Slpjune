package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notepad 
{

  public static void main(String[] args) throws IOException 
  {
	  Library Lb=new Library();
      
      Lb.OpenApp("http://183.82.100.55/ranford2");
      Lb.AdminLgn("Admin","M1ndq");
      
	  //To get test data file path
      
      String Fpath="E:\\AftnOct\\Ebanking\\src\\com\\ebanking\\testdata\\Role.txt";
      
      //Results File Path
      
      String Rpath="E:\\AftnOct\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.txt";
      String SD;
      //To Get Test Data File
      
      FileReader Fr=new FileReader(Fpath);
      BufferedReader Br=new BufferedReader(Fr);
      String Sread=Br.readLine();
      System.out.println(Sread);
      
      
      //To write
      
      FileWriter Fw=new FileWriter(Rpath);
      BufferedWriter Bw=new BufferedWriter(Fw);
      Bw.write(Sread);
      Bw.newLine();
      
      //Multiple Iterations--- While loop
      
      while ((SD=Br.readLine())!=null)
      {
		System.out.println(SD);
		
		String SR[]=SD.split("###");
		
		String Rname=SR[0];
		String Rdes=SR[1];
		String Rtyp=SR[2];
		
		String Res=Lb.RoleCre(Rname,Rdes,Rtyp);
		System.out.println(Res);
		
		//Results
		
		//Bw.write(SD+"@@@"+Res);
		Bw.write(Rname+"$$$$"+Rdes+"%%%"+Rtyp+"&&&&"+Res);		
		Bw.newLine();
		
		
		
	}
      Bw.close();
      Br.close();
      
      
      
      
      
      
      
      
	}

}
