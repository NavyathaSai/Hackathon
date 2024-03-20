package PageObjects;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class urbanLadderPage extends BasePage{
    //Constructor
	public urbanLadderPage(WebDriver driver) {
		super(driver);
	}
	Actions act=new Actions(driver);
	JavascriptExecutor js= (JavascriptExecutor)driver;
	//Locators
	
	//For bookshelves
	@FindBy(xpath="//a[@href='/bookshelf?src=explore_categories']")
	WebElement click_bookshelves;
	
	//For Gift cards
	@FindBy(xpath="//a[text()=' Gift Cards ']")
	WebElement giftCards;
	
	//Actions
	public void clickBookshelves() {
		act.moveToElement(click_bookshelves).click().perform();
	}
	
	public void clkGiftCards() {
		js.executeScript("arguments[0].click();", giftCards);
	}

}
