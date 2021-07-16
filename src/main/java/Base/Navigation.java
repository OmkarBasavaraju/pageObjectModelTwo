package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.CreateAccount;

public class Navigation {
	
	public static WebDriver driver;
	
	public Navigation(WebDriver driver) {
		this.driver = driver;
	}
	
	public static CreateAccount account() {
		driver.findElement(By.cssSelector("#mainMenuTabDiv > crm-menu > div.crmMenuLeft.fL > crm-tab > div.lyteMenuItems > div:nth-child(4) > a")).click();
		driver.findElement(By.cssSelector("#table_row_1 > lyte-td.alignRight > span.customPluswithImpotBtnCon.pR.cPlusImportButton.vam > link-to > button")).click();
	    return new CreateAccount();
	}
}
