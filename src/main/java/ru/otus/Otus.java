package ru.otus;



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

import static org.junit.Assert.assertEquals;

public class Otus {
    private static final Logger logger = LogManager.getLogger("ru.otus.Otus");
    public static void main(String[] args) {

        logger.info("Log4j2ExampleApp started.");
        Otus otus = new Otus();
        try {
            otus.setUp();
            otus.testOtus();
            logger.info("Test complete");
        } catch (Exception e) {
            logger.error("Error message", e);
        }
    }

    @Before
    public void setUp() throws Exception {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "D:\\projects\\chromedriver_win32\\chromedriver.exe");
    }


    @Test
    public void testOtus() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.otus.ru/");

        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/header[1]/div/div[2]/div[1]/a[5]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        element = driver.findElement(By.xpath("//div[@class='c0qfa0-1 lblsQs']/div[@class='c0qfa0-5 cXQVNI']"));



        String actualAddress = element.getText();

        String expectedAddress = "125167, г. Москва, Нарышкинская аллея., д. 5, стр. 2, тел. +7 499 938-92-02";

        assertEquals(expectedAddress,actualAddress);

        driver.manage().window().maximize();
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();

        String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";

        assertEquals(expectedTitle,actualTitle);

        Thread.sleep(2000);  // Let the user actually see something!

        driver.quit();

    }

}
