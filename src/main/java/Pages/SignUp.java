package Pages;

import Base.Base;

public class SignUp extends Base {


	public AppPage signUphj(String UserName, String Password ){
		type("emailField",UserName);
		click("nextButton");
		type("passwordField", Password);
		click("nextButton");
		click("crmButton");
//		wait.until(ExpectedConditions.alertIsPresent()).accept();
		return new AppPage();
	}
}
