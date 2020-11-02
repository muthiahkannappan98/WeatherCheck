package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.response.Response;

public class FunctionLibrary {
	protected static WebDriver driver = null;
	protected Response result = null;
	protected static LinkedList<String> data = new LinkedList<String>();
	List<Weather> weatherlist = new ArrayList<Weather>();
	protected static Weather ui = new Weather();
	protected static Weather api = new Weather();

	/*
	 * Name and Details: To load excel data created: 10/31/2020 return type:
	 * LinkedList author: muthiah.kannappan
	 */
	
	public LinkedList<String> loadExcelData() throws IOException {
		int i = 0, j = 0;

		String excelfilepath = System.getProperty("user.dir") + "/src/test/resources/Data.xlsx";
		FileInputStream inputstream = new FileInputStream(new File(excelfilepath));
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		Sheet firstsheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstsheet.iterator();
		while (iterator.hasNext()) {
			Row nextrow = iterator.next();
			Iterator<Cell> celliterator = nextrow.cellIterator();
			if (i >= 1) {
				while (celliterator.hasNext()) {

					Cell cell = celliterator.next();
					j++;
					if (j >= 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							System.out.print(cell.getStringCellValue());
							data.add(cell.getStringCellValue());
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							System.out.print(cell.getBooleanCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							System.out.print(cell.getNumericCellValue());
							data.add(Double.toString(cell.getNumericCellValue()));
							break;
						}
					}
					System.out.print(" - ");
				}
				j = 0;
			}
			System.out.println();
			i++;
		}
		System.out.println(data);
		inputstream.close();
		return data;

	}

	/*
	 * Name and Details: Click on web element if displayed and enabled created:
	 * 10/31/2020 return type: Void author: muthiah.kannappan
	 */
	
	public void clickWebElement(WebElement we, String description) {
		if (we.isDisplayed() && we.isEnabled()) {
			we.click();
			System.out.println("Web element " + description + " clicked succssfully");
		}
	}

	/*
	 * Name and Details: Enter value on web element if displayed and enabled
	 * created: 10/31/2020 return type: Void author: muthiah.kannappan
	 */
	
	public void enterWebElement(WebElement we, String value, String description) {
		if (we.isDisplayed() && we.isEnabled()) {
			we.sendKeys(value);
			System.out.println("In web element " + description + " value " + value + " is entered succssfully");
		}
	}

	/*
	 * Name and Details: Check web element if displayed created: 10/31/2020 return
	 * type: Boolean author: muthiah.kannappan
	 */
	
	public boolean checkWebElement(WebElement we, String description) {
		if (!we.isDisplayed()) {
			System.err.println(description + " element not dispalyed");
			return false;
		}
		return true;
	}

	/*
	 * Name and Details: Get text value from webelement created: 11/1/2020 return
	 * type: Float author: muthiah.kannappan
	 */
	
	public float getValue(WebElement we) {
		return Float.parseFloat(we.getText().replaceAll("[^0-9]", ""));
	}

	/*
	 * Name and Details: Wait for webelement created: 11/1/2020 return type: Void
	 * author: muthiah.kannappan
	 */
	
	public void waitForElement(String we) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we)));
	}

	/*
	 * Name and Details: Get rest response body created: 11/1/2020 return type: Void
	 * author: muthiah.kannappan
	 */
	
	public Response getResponseBody(String URL) {
		result = given().queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").queryParam("units", "metric").when()
				.get(URL);
		System.out.println(result);
		return result;
	}

	/*
	 * Name and Details: Compare weather objects created: 11/2/2020 return type:
	 * Void author: muthiah.kannappan
	 */
	
	public void compareObjects() {
		weatherlist.add(ui);
		weatherlist.add(api);
		System.out.println(ui.getDegree() + " UI Degree temp " + api.getDegree() + " API  Degree temp");
		Collections.sort(weatherlist, new WeatherComparator());
		System.out.println(weatherlist);
	}

}
