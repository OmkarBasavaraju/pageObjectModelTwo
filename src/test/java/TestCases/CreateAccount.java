package TestCases;

import org.testng.annotations.Test;

import Base.Base;
import Pages.AppPage;
import Pages.LandingPageT1;
import Pages.SignUp;

public class CreateAccount {

	@Test(priority =2)
	public void CreateAccount() {
		Pages.CreateAccount createAcc = Base.nav.account();
		createAcc.CreateAccount();
		Base.nav.account();
	}
}
