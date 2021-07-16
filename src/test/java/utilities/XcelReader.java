package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Base.Base;

public class XcelReader extends Base {

	public static Workbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static int colCount;
	public static int rowcount;

	public int XcelRowCount() throws EncryptedDocumentException, IOException {
		File Excel = new File(config.getProperty("ExcelPath"));
		FileInputStream fileinput = new FileInputStream(Excel);
		workbook = WorkbookFactory.create(fileinput);
		sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		return rowcount;
	}

	public int XcelColCount() {
		row = sheet.getRow(0);
		colCount = row.getLastCellNum();
		System.out.println(colCount);
		return colCount;
	}

	public String getData(String SheetName, int rowCount, int colCount) {

		Row rowData = sheet.getRow(rowCount);
		Cell cell = rowData.getCell(colCount);

		if (cell.getCellType() == CellType.STRING) {
			System.out.println(cell.getStringCellValue());
			return cell.getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			System.out.println(cell.getNumericCellValue());
			return Double.toString(cell.getNumericCellValue());
		} else
			return ("Field is neither String or Numeric");
	}
}
