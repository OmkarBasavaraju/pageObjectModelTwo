package Pages;

import org.openqa.selenium.By;
import Base.Base;

public class LandingPageT1 extends Base {

	public void customer() {
		click("signIn");
	}
	
	public void support() {
		
	}
	
	public void contactSales() {
		
	}
	
	public SignUp SignIn() {
		System.out.println("IN");
		click("signIn");
		System.out.println("out");
		return new SignUp();
	}
	
	public SignUp freeSignUp() {
		driver.findElement(By.cssSelector("body > div.main-container-wrapper > div.zh-header-wrap > div > a.zh-signup")).click();
		
		return new SignUp();
	}

}
