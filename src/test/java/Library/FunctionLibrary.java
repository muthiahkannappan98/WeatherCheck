package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static io.restassured.RestAssured.*;
import java.util.Iterator;
import java.util.LinkedList;
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
	protected Response result=null;
	LinkedList<String> data = 
	            new LinkedList<String>();
	 protected Weather ui=new Weather();
	 protected  Weather api=new Weather();
	public LinkedList<String> loadExcelData() throws IOException
	{
		int i=0,j=0;
		 
		String excelFilePath =  System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
         
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            if(i>=1)
        	{
            while (cellIterator.hasNext()) {
            	
                Cell cell = cellIterator.next();
                 j++;
                 if(j>=1)
                 {
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
            j=0;
            }
            System.out.println();
            i++;
        }
        System.out.println(data);
        inputStream.close();
		return data;
		
	}
	
	public void clickWebElement(WebElement we,String description)
	{
		if(we.isDisplayed() && we.isEnabled())
		{
			we.click();
			System.out.println("Web element "+description+" clicked succssfully");
		}
	}
	
	public void enterWebElement(WebElement we,String value,String description)
	{
		if(we.isDisplayed() && we.isEnabled())
		{
			we.sendKeys(value);
			System.out.println("In web element "+description+" value "+value+" is entered succssfully");
		}
	}
	
	public boolean checkWebElement(WebElement we,String description)
	{
		if(!we.isDisplayed())
		{
			System.err.println(description+" element not dispalyed");
			return false;
		}
		return true;
	}
	
	public void moveToWebElement(WebElement we,String description)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", we);
		System.out.println("Moved to web element "+description);
	}
	
	public int getValue(WebElement we)
	{
			return Integer.parseInt(we.getText());
	}
	
	public void waitForElement(String we)
	{
		 WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we)));
	}
	
	public Response getResponseBody(String URL)
	{
		result =given().queryParam("",data.get(0))
        .queryParam("appid","7fe67bf08c80ded756e598d6f8fedaea").queryParam("units","metric")
        .when().get(URL);
		return result;
	}
	
	
	
}
