package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestEg1 {
    WebDriver driver;
    @BeforeTest
    public void open() 
    {
        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver();

    }

    @Test(priority = 1)
    public void test1() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in/");
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void test2() throws InterruptedException
    {
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("skcet"+Keys.ENTER);
        Assert.assertEquals("skcet - Google Search", driver.getTitle());
        System.out.println(driver.getTitle());
               
    }
    @Test(priority = 3)
    public void test3() throws InterruptedException
    {
        driver.findElement(By.cssSelector("h3")).click();
        Thread.sleep(3000);        
        driver.findElement(By.xpath("//*[@id='popmake-6187']/button")).click();
        Thread.sleep(3000);        
    }
    @AfterClass
    public void close()
    {
        driver.quit();
    }
}
