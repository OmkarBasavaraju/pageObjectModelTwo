package TestCases;

import org.testng.annotations.Test;

import Pages.AppPage;
import Pages.LandingPageT1;
import Pages.SignUp;
import utilities.Screenshot;

public class Login {

	@Test(priority =1,dataProviderClass = Screenshot.class,dataProvider = "dp")
	public void login(String Username,String Password ) {
		LandingPageT1 l = new LandingPageT1();
		SignUp s = l.SignIn();
		AppPage app = s.signUphj(Username , Password);
	}
}
