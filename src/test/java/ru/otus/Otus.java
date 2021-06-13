package ru.otus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Otus {

    WebDriver driver = new ChromeDriver();

    System.setProperty("webdriver.chrome.driver", "D:/projects/resources/chromedriver.exe");

    driver.manage().window().maximaze();


}
