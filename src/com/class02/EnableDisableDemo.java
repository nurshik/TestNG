package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EnableDisableDemo {
    WebDriver driver;

    @BeforeMethod
    public void openBrowserAndLaunchApp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void firstMethod() {
        System.out.println("This should be second");
    }

    @Test(priority = 1, enabled = false)
    public void secondMethod() {
        System.out.println("This should be first");
    }

    @Test(priority = 2, enabled = false)
    public void thirdMethod() {
        System.out.println("This should be third");
    }

    @Test(priority = 3,enabled = true)
    public void invalidLogin() {

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        // driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement errorMessage = driver.findElement(By.id("spanMessage"));

        String receivingText = errorMessage.getText();
        String actualText = "Password cannot be empty";
        Assert.assertEquals(receivingText, actualText);
        System.out.println("Test is passed");
    }

    @Test(priority = 2,enabled = true)
    public void validationOfTitle(){
        String expectedTitle="Human Management System";
        String actualTitle=driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Test2 is final and title is the same");
        }   else{
            System.out.println("Test2 is failed");
        }
    }
    @Test(priority = 1,enabled = true)
    public void validLogin() {

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[text() = 'Welcome Admin']"));
        if(welcomeAttribute.isDisplayed()) {
            System.out.println("Test1 is valid and Passed");
        } else {
            System.out.println("Test1 is failed");
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}