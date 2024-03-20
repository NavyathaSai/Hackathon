package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//Other page classes can extend BasePage to reuse common methods and properties
public class BasePage {
	public WebDriver driver;
	BasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
}