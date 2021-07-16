package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static Navigation nav;
	public static WebDriverWait wait;
	public static Properties config;
	public static Properties OR;
	public static String browser;

	public Base() {
		config = new Properties();
		OR = new Properties();
		String ConfigPath = (System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Config.properties");
		String OrPath = (System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\OR.properties");
		System.out.println(ConfigPath);
		System.out.println(OrPath);
		File f = new File(ConfigPath);
		File f1 = new File(OrPath);
		

		FileInputStream fi = null;
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream fiOne = null;
		try {
			fiOne = new FileInputStream(f1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fiOne);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (((System.getenv("browser")) != null) && !(System.getenv("browser").isEmpty())) {

			browser = System.getenv("browser");

		} else {
			System.out.println("test1");
			
			browser = config.getProperty("browser");
		}

		config.setProperty("browser", browser);
		nav = new Navigation(driver);
		
		if (driver == null) {
			if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(config.getProperty("testsiteUrl"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				wait = new WebDriverWait(driver, 10);
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(config.getProperty("testsiteUrl"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				wait = new WebDriverWait(driver, 10);
			}
		}
	}

	public void click(String locator) {
		System.out.println(OR.getProperty("signIn"));
		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
	}

	public void type(String locator, String Text) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(Text);
	}

	public void selectDropdown(WebElement element) {
		Select select = new Select(element);
		select.selectByIndex(0);
	}

//	@AfterTest
//	public void tearDown(){
//		driver.quit();
//	}
	
}
