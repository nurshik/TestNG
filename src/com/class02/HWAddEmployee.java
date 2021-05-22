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

public class HWAddEmployee {
    /*
    HRMS Add Employee:
Open chrome browser
Go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
Login into the application
Click on Add Employee
Verify labels: Full Name, Employee Id, Photograph are displayed
Provide Employee First and Last Name
Add a picture to the profile
Verify Employee has been added successfully
Close the browser
     */
    WebDriver driver;

    @BeforeMethod
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );

    }
    @Test
    public void verifyLabels(){
        WebElement PIMButton= driver.findElement(By.linkText("PIM"));
        PIMButton.click();
        WebElement addEmployeeButton= driver.findElement(By.linkText("Add Employee"));
        addEmployeeButton.click();
        SoftAssert soft=new SoftAssert();
        WebElement fullName= driver.findElement(By.xpath("//*[text()='Full Name']"));
        soft.assertTrue(fullName.isDisplayed());
        WebElement employeeId= driver.findElement(By.xpath("//*[text()='Employee Id']"));
        soft.assertTrue(employeeId.isDisplayed());
        WebElement photograph= driver.findElement(By.xpath("//*[text()='Photograph']"));
        soft.assertTrue(photograph.isDisplayed());

        soft.assertAll();
    }
    @Test
    public void fillOutData(){
    WebElement firstNameBox= driver.findElement(By.id("firstName"));
    firstNameBox.sendKeys("John");
    WebElement lastNameBox= driver.findElement(By.id("lastName"));
    lastNameBox.sendKeys("Smith");
    WebElement photoFile= driver.findElement(By.name("photofile"));
    photoFile.sendKeys("C:\\Users\\formy\\Desktop\\image007.png");

    WebElement personalDetails= driver.findElement(By.cssSelector("div.personalDetails"));
        System.out.println(personalDetails.isDisplayed());
    }
//    @AfterMethod
//    public void closeBrowser(){
//        driver.quit();
//    }

}