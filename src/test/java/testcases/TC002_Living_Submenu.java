package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.Submenu;
import testBase.BaseClass;

public class TC002_Living_Submenu extends BaseClass{
	
	@Test(priority=1,groups= {"sanity","master"})
	public void viewLiving() throws InterruptedException {
		System.out.println("Living Submenu Details:");
		Submenu sb= new Submenu(driver);
		logger.info("------Mouse hovering to the header Living-------");
		sb.HoverToLiving();
	}
	@Test(priority=2,groups= {"regression","master"})
	public void printSubmenu() throws IOException {
		Submenu sb= new Submenu(driver);
		logger.info("------Printing the menu list of seating&chairs-------");
		sb.Chairs();
		System.out.println("===============================================");
		
	}

}