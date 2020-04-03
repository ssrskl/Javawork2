package com.maoyan.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Maoyan
 * @data 2020/3/31 21:32
 * @Version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        WebDriver driver  = new FirefoxDriver();
        driver.get("http://www.baidu.com");

        WebElement searchBox = driver.findElement(By.id("kw"));
        searchBox.sendKeys("小坦克 博客园");
        WebElement searchButton = driver.findElement(By.id("su"));
        searchButton.submit();

        driver.close();
    }
}
