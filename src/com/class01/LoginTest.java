package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
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
    @Test
    public void validationOfTitle(){
        String expectedTitle="Human Management System";
        String actualTitle=driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Test2 is final and title is the same");
        }   else{
            System.out.println("Test2 is failed");
        }
    }
   @AfterMethod
    public void tearDown(){
        driver.quit();
   }
}

//Select project ->Go to Run->Edit Configuration_>select XML file-> go to Listeners->search for EmailableReporter and FailedReporter-Add