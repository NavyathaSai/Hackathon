 package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.excelUtils;

public class Submenu extends BasePage{
    //Constructor
	public Submenu(WebDriver driver) {
		super(driver);
	}
	
	Actions act=new Actions(driver);
	//Locators
	
	//For living
	@FindBy(xpath="//li[@class=\"topnav_item livingunit\"]/span")
	WebElement Living;
	
	@FindBy(xpath="//a[@href='/chair?src=g_topnav_living_seating-chairs']")
	WebElement Chairs;
	
	//submenu in living --> chair
	@FindBy(xpath="//ul/li[3]/div/div/ul/li[1]//a")
	List<WebElement>  submenu;
	
	//Actions
    //Clicking Living SubMenu
	public void HoverToLiving() throws InterruptedException {
		act.clickAndHold(Living).perform();
		Thread.sleep(3000);;
	}
	
	//Printing the submenu
	public void Chairs() throws IOException {
		int row=1;
		for(WebElement seat : submenu) {
			System.out.println(seat.getText());
			excelUtils.setCellData("XLwrite",row ,1 ,seat.getText() );
			row++;
		}

	}
	
}
