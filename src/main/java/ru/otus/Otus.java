package ru.otus;



import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Otus {

    public static void main(String[] args) throws InterruptedException {
        Otus otus = new Otus();

        otus.testOtus();
    }

    @Test

    public void testOtus() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\projects\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.otus.ru/");

        Thread.sleep(5000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        assertEquals(expectedTitle,actualTitle);

        Thread.sleep(1000);  // Let the user actually see something!

        driver.quit();

    }

}
