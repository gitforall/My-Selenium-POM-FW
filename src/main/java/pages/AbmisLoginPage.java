package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbmisLoginPage {
	
	
	public AbmisLoginPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy(id="UserName") 	WebElement username;	
	@FindBy(id="Password") 	WebElement Password;
	@FindBy(id="submit") WebElement submitbtn;
	@FindBy(className="logout-btn") WebElement logout;
	
	public void loginIntoApplication(String UN, String pwd) throws InterruptedException{
		
	try{
			username.sendKeys(UN);
			Password.sendKeys(pwd);	
			submitbtn.click();
			Thread.sleep(5000L);
			logout.click();
		} 
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
	
	
}
