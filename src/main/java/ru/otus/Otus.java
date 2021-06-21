package ru.otus;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Otus {
    private static final Logger logger = LogManager.getLogger("ru.otus.Otus");
    public static void main(String[] args) {

        logger.info("Log4j2ExampleApp started.");
        Otus otus = new Otus();
        try {
            otus.setUp();
            otus.testPlan();
            logger.info("Test complete");
        } catch (Exception e) {
            logger.error("Error message", e);
        }
    }

    @Before
    public void setUp() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "D:\\projects\\chromedriver_win32\\chromedriver.exe");
    }

    @Test
    public void testPlan() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

//        Set implicit wait:
//        wait for WebElement
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

//        wait for loading page
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        driver.get("http://www.otus.ru/");

        WebElement element = driver.findElement(By.xpath("//div[@class='header2_subheader-container header2_subheader-container__inline']/a[@title='Контакты']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);


        element = driver.findElement(By.xpath("//div[@class='c0qfa0-1 lblsQs']/div[@class='c0qfa0-5 cXQVNI']"));
        String actualAddress = element.getText();
        String expectedAddress = "125167, г. Москва, Нарышкинская аллея., д. 5, стр. 2, тел. +7 499 938-92-02";
        assertEquals(expectedAddress,actualAddress);


        driver.manage().window().maximize();


        String actualTitle = driver.getTitle();
        String expectedTitle = "Контакты | OTUS";
        assertEquals(expectedTitle,actualTitle);


        driver.get("https://msk.tele2.ru/shop/number");
        element = driver.findElement(By.xpath("//div[@class='text-field-holder']/input[@class='text-field']"));
        element.sendKeys("97");
        WebElement expectedElement = driver.findElement(By.xpath("//div[@class='numbers-slider-wrap']/div[@class='numbers-slider']"));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        driver.get("http://www.otus.ru/");
        element = driver.findElement(By.xpath("//div[@class='header2_subheader-container header2_subheader-container__inline']/a[@title='FAQ']"));

        executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        Thread.sleep(5000);

        driver.quit();

    }

}
