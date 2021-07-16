package rough;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Base.Base;
import Pages.AppPage;
import Pages.CreateAccount;
import Pages.LandingPageT1;
import Pages.SignUp;
import io.github.bonigarcia.wdm.WebDriverManager;

public class roughh {

	@Test
	public void testcases() {

	CreateAccount createAcc = Base.nav.account();
	createAcc.CreateAccount();
	}
}
