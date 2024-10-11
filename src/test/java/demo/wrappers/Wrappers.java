package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {

   
    

    /*
     * Write your selenium wrappers here
     */

    public static void enterText(WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void radioButton(ChromeDriver driver, String radioButtonText){
        try{
            WebElement element = driver.findElement(By.xpath("//span[text()='"+radioButtonText+"']/ancestor::div[@role='radiogroup']//div[contains(@class,'vd3tt')]"));
            element.click();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void checkBox(ChromeDriver driver, String checkBoxText){
        try{
            WebElement element = driver.findElement(By.xpath("//span[contains(@class, 'n5vBHf') and contains(text(), '" + checkBoxText + "')]/../../preceding-sibling::div[contains(@id, 'i')]"));
            element.click();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void dropDownClick(ChromeDriver driver, String dropDownText){
        try{
            WebElement element = driver.findElement(By.xpath("(//div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb')]//span[text()='"+dropDownText+"'])[2]"));
            element.click();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void clickOnElement(ChromeDriver driver, WebElement element){
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String getdataSevenDaysAgo(){
        LocalDate currentDate = LocalDate.now();
        LocalDate dateMinus7Days = currentDate.minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatteDate = dateMinus7Days.format(formatter);
        return formatteDate;
    }

    public static  String getEpochTimeAsString(){
        long epochTime = System.currentTimeMillis()/1000;
        String epochTimeString = String.valueOf(epochTime);
        return epochTimeString;
    }

    private WebElement waitForElementVisible(By locator, int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'waitForElementVisible'");
    }
}
