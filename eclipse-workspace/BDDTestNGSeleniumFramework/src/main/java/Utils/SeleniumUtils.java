package Utils;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	   WebDriver driver;

	    public SeleniumUtils(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void clickElement(WebElement element) {
	        element.click();
	    }

	    public void elementIsDisplayed(WebElement element) {
	        element.isDisplayed();
	    }
	    public void enterText(WebElement element, String text) {
	        element.clear();
	        element.sendKeys(text);
	    }

	    public void waitForElement(WebElement element) {
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.visibilityOf(element));
	    }
	    
	    public void acceptAlert() {
	        try {
	            Alert alert = driver.switchTo().alert();
	            System.out.println("Alert text: " + alert.getText());
	            alert.accept();
	        } catch (NoAlertPresentException e) {
	            System.out.println("No alert present.");
	        }
	    }

	    public void dismissAlert() {
	        try {
	            Alert alert = driver.switchTo().alert();
	            alert.dismiss();
	        } catch (NoAlertPresentException e) {
	            System.out.println("No alert present.");
	        }
	    }

	    public String getAlertText() {
	        try {
	            return driver.switchTo().alert().getText();
	        } catch (NoAlertPresentException e) {
	            return "No alert present.";
	        }
	    }
	    public boolean isProductRemoved(List<WebElement> cartItems, String productName) {
	        for (WebElement item : cartItems) {
	            if (item.getText().contains(productName)) {
	                return false; // Product still in cart
	            }
	        }
	        return true; // Product not found
	    }
	    public String[] getLoginDataFromExcel(int rowIndex) {
	        String[] data = new String[2];
	        try (FileInputStream fis = new FileInputStream("src/test/resources/testdata.xlsx");
	             Workbook workbook = new XSSFWorkbook(fis)) {
	            Sheet sheet = workbook.getSheetAt(0);
	            Row row = sheet.getRow(rowIndex);

	            if (row == null || row.getCell(0) == null || row.getCell(1) == null) {
	                throw new IllegalArgumentException("Row or cell is missing");
	            }

	            data[0] = row.getCell(0).toString();
	            data[1] = row.getCell(1).toString();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return data;
	    }
	     
	      
	    }

