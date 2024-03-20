package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.BookShelves;
import PageObjects.urbanLadderPage;
import testBase.BaseClass;

public class TC001_BookShelves extends BaseClass{
	
	@Test(priority=1,groups= {"sanity","regression","master"})
    public void select_bookshelves() {
		urbanLadderPage ul=new urbanLadderPage(driver);
    	logger.info("------Select BookShelves-------");
    	ul.clickBookshelves();
    	logger.info("------Handled the popup-------");
    	BookShelves bs=new BookShelves(driver);
		bs.closePopup();
		System.out.println("BOOKSHELVES DETAILS:");
    }
	
	@Test(priority=2,groups= {"regression","master"})
	public void SelectFilters() throws InterruptedException {
		BookShelves bs=new BookShelves(driver);
		Thread.sleep(2000);
		logger.info("------Choosing product under ₹15,000-------");
		bs.price();
		logger.info("------Choosing the product category-------");
		bs.category();
		logger.info("------Clicking the Checkbox exclude out of stock-------");
		bs.ExcludeOutOfStock();
	}
	
	@Test(priority=3,groups= {"regression","master"})
	public void printProductDetails() throws InterruptedException, IOException {
		BookShelves bs=new BookShelves(driver);
		Thread.sleep(5000);
		logger.info("------Printing the product details-------");
		bs.productDetails();
		System.out.println("===============================================");
	}
}
