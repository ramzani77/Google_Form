package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation.
     * Follow `testCase01` `testCase02`... format or what is provided in
     * instructions
     */

    /*
     * Do not change the provided methods unless necessary, they will help in
     * automation and assessment
     */
    @BeforeTest
    public void startBrowser() {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @Test
    public void testCase01() throws InterruptedException {

        driver.get(
                "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform?pli=1");
        Thread.sleep(3000);
        

        WebElement nameField = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]"));
        
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.visibilityOf(nameField));





        System.out.println("wait1");
        Wrappers.enterText(nameField, "Crio Learner");

        WebElement PracticeFieldTextArea = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        String PracticeFieldText ="I want to be the best QA Engineer!";
        
        String epchtimeString = Wrappers.getEpochTimeAsString();

        Thread.sleep(3000);
        System.out.println("wait2");

        Wrappers.enterText(PracticeFieldTextArea, PracticeFieldText+ " " + epchtimeString);

        Thread.sleep(5000);
        System.out.println("wait3");

        Wrappers.radioButton(driver, "0 - 2");

        Thread.sleep(5000);
        System.out.println("wait4");

        Wrappers.checkBox(driver, "Java");
        Wrappers.checkBox(driver, "Selenium");
        Wrappers.checkBox(driver, "TestNG");

        WebElement dropDown = driver.findElement(By.xpath("(//div[@class='e2CuFe eU809d'])[1]"));
        dropDown.click();
        Thread.sleep(2000);

        WebElement dropDownOption = driver
                .findElement(By.xpath("(//div[contains(@class,'ncFHed')]/div[normalize-space()])[2]"));
        
                Thread.sleep(3000);
                System.out.println("wait5");

                Wrappers.clickOnElement(driver, dropDownOption);

                Wrappers.dropDownClick(driver, "Mr");
                
                
        

        // LocalDate currentDate = LocalDate.now();
        // LocalDate PostDate = currentDate.minusDays(7);
        // DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        // String reqDate = PostDate.format(dateFormat);

        WebElement dateFiled = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[2]"));
        String savenDaysAgoDate = Wrappers.getdataSevenDaysAgo();

        Thread.sleep(3000);
        System.out.println("wait6");

        Wrappers.enterText(dateFiled, savenDaysAgoDate);



        WebElement timeFiledHour = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[3]"));
        

        WebElement timeFiledMin = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[4]"));
       

        WebElement submitButton = driver.findElement(By.xpath("(//span[@class='NPEfkd RveJvd snByac'])[1]"));
       
        Wrappers.enterText(timeFiledHour, "07");
        Wrappers.enterText(timeFiledMin, "30");
        Wrappers.clickOnElement(driver, submitButton);

        
        Thread.sleep(3000);
        System.out.println("wait7");



        WebElement sucessMsgElement = driver
                .findElement(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']"));
                Thread.sleep(2000);
            String expectedSuccessMsg = "Thanks for your response, Automation Wizard!";
            Thread.sleep(2000);
            Assert.assertEquals(sucessMsgElement.getText().trim(), expectedSuccessMsg);
            Thread.sleep(3000);
        
    

    }

    private Duration DurationOfSeconds(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DurationOfSeconds'");
    }

    @AfterTest
    public void endTest() {
        driver.close();
        driver.quit();

    }
}