package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task1_2 {
    WebDriver driver;

    @BeforeMethod
    public void openBrowserAndLaunchApp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void invalidLogin() {

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
       // driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement errorMessage=driver.findElement(By.id("spanMessage"));

        String receivingText= errorMessage.getText();
        String actualText="Password cannot be empty";
        Assert.assertEquals(receivingText,actualText);
        System.out.println("Test is passed");

//        if(receivingText.equals(actualText)){
//            System.out.println("Test is passed and error displayed");
//        }   else{
//            System.out.println("Test is failed");
//        }

    }
}