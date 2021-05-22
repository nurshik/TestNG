package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertionHRMS {
    WebDriver driver;

    @BeforeMethod
    public void openBrowserAndLaunchApp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void loginAndValidateTitle(){
        String expectedTitle="Human Management System";
        String actualTitle=driver.getTitle();

        SoftAssert soft=new SoftAssert();
        soft.assertEquals(expectedTitle,actualTitle);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[text() = 'Welcome Admin']"));
        String recevedValue=welcomeAttribute.getText();
        String existedValue="Welcome Admin123";
        soft.assertEquals(recevedValue,existedValue);
        System.out.println("Test is not working");
        soft.assertAll();
    }
//    @AfterMethod
//    public void closeBrowser(){
//        driver.quit();
//    }
}
