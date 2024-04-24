package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
    WebDriver driver;
    @BeforeTest
    public void open(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test 
    public void t1() throws InterruptedException
    {
        driver.get("https://economictimes.indiatimes.com/et-now/results");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='topnav']/div[10]/a")).click();
        // Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(), 'Results')]")).isDisplayed());
        WebElement e1=driver.findElement(By.xpath("//*[@id='amcSelection']"));
        e1.sendKeys("Canara Robeco");
        WebElement e2=driver.findElement(By.xpath("//*[@id='schemenm']"));
        e2.sendKeys("Canara Robeco Bluechip Equity Direct-G");
        driver.findElement(By.xpath("//*[@id='anchor3']")).click();
    }

}