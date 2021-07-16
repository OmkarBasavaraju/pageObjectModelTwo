package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import Base.Base;

public class Screenshot extends Base {
	XcelReader dataj = new XcelReader();
	static Screenshot sd = new Screenshot();

	public void Screenshot() {

		File Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File f = new File(
				"C:\\Users\\IGSA937002\\eclipse-workspace\\PageObjectModel\\Report\\Scrrenshot" + "\\error.png");
		try {
			FileUtils.copyFile(Screenshot, f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	sd.data();
	}

	@DataProvider(name="dp")
	public Object[][] data() throws EncryptedDocumentException, IOException {
	
		int rowc = dataj.XcelRowCount();
		int colc = dataj.XcelColCount();
		Object[][] obj = new Object[rowc][colc];
		System.out.println(rowc);
		System.out.println(colc);
		for (int i = 1; i < rowc+1; i++) {
			for (int j = 0; j < colc; j++) {
				obj[i-1][j] = dataj.getData("login", i, j);
			}
		}
		return obj;
	}
}
