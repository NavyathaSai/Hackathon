package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.excelUtils;

public class BookShelves extends BasePage {
    //constructor
	public BookShelves(WebDriver driver) {
		super(driver);	
	}
	Actions act=new Actions(driver);
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	//locators
	
	//for popup
	@FindBy(xpath="//a[@data-gaaction='popup.auth.close']")
	WebElement popup;
	
	//for price
	@FindBy(xpath="(//div[@class='gname'])[1]")
	WebElement price;
	
	
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-upper']")
	WebElement maxPrice;
	
	//for storage type
	@FindBy(xpath="//li[@data-group='storage type']")
	WebElement category;
	
	//checkbox open
	@FindBy(xpath="//input[@value='Open']")
	WebElement open;
	
	//for ExcludeOutOfStock
	@FindBy(id="filters_availability_In_Stock_Only")
	WebElement ExOutStock;
	
	//To get the productTitle
	@FindBy(xpath="//div[@class='product-title product-title-sofa-mattresses']")
	List<WebElement> productTitle;
	
	//To get the cost of the product
	@FindBy(xpath="//div[@class='price-number']/span")
	List<WebElement> productPrice;
	
	//Actions
	public void closePopup() {
		popup.click();
	}
	
	//To set the price upto 15000/-
	public void price() throws InterruptedException {
		Thread.sleep(5000);
		act.moveToElement(price).perform();
		Thread.sleep(2000);
		act.dragAndDropBy(maxPrice, -274,0).perform();
	}
	
	//To select open option from the drop down menu
	public void category() throws InterruptedException {
		act.moveToElement(category).perform();
		//Not able to click exception
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()",open);
	}
	
	//To click on excludeOutOfStock check box
	public void ExcludeOutOfStock() throws InterruptedException {
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", ExOutStock);
	}
	
	public void productDetails() throws IOException {
		int row=1;
		
		//To get the first 3 products
		for(int i=0;i<3;i++) {
			String pTitle=productTitle.get(i).getText();
			String pPrice=productPrice.get(i).getText();
			System.out.println(pTitle+"  :  "+pPrice+"\n");
			excelUtils.setCellData("XLwrite", row, 0, pTitle);
			row++;
			excelUtils.setCellData("XLwrite", row, 0, pPrice);
			row++;
		}
		
		//To scroll the webpage
		js.executeScript("window.scrollBy(0,-300)");
	}
	


}
