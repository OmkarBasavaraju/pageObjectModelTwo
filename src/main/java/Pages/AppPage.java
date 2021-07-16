package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;

public class AppPage extends Base {
	
	
	public void gotoCRM() {
		WebDriverWait wait = new WebDriverWait(driver, 13);
		System.out.println("test");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"zl-category-1\"]/div/ul/li[1]/div/a/span")));
		driver.findElement(By.cssSelector("#zl-category-1 > div > ul > li:nth-child(1) > div > p")).click();
		Point crm = driver.findElement(By.xpath("//*[@id=\"zl-category-1\"]/div/ul/li[1]/div/a/span")).getLocation();
		int x  = crm.getX();
		int y = crm.getY();
		System.out.println(x);
		System.out.println(y);
		Actions a = new Actions(driver);
		a.moveByOffset(x, y).click().perform();
//		
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].scrollIntoView(true);", crm);    
//		crm.click();
		System.out.println("test1");
	}
	
	public void gotoMail() {
		driver.findElement(By.cssSelector("#block-system-main > div.zremote-works-wrap > div.zremotely-wrap > a")).click();
	}
	
	public void gotoDesk() {
		driver.findElement(By.cssSelector("#block-system-main > div.zh-zoho-one-promo-sec > div > div.zh-zoho-one-logo > a")).click();
	}

}
