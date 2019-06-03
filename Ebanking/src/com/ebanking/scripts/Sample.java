package com.ebanking.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample 
{
   @Test
   public void xyz()
	{
		Assert.assertEquals("selenium","selenium");
	}
	@Test
	public void abc()
	{
		Assert.assertEquals("TestNg","TestNg");
	}
	@Test
	public void pqr()
	{
		Assert.assertEquals("Java","Java");
	}
}
