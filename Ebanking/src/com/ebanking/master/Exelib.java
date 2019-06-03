package com.ebanking.master;

import java.io.IOException;

public class Exelib 
{
	public static void main(String[] args) throws IOException
	{
	Library Lb=new Library();
	
	Lb.OpenApp("http://192.168.1.4/ranford2");
	Lb.AdminLgn("Admin","Admin");
	Lb.RoleCre("Tellermq","Teller","E");
	}

}
