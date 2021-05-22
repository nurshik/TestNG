package com.class01;

import org.testng.annotations.*;

public class PreAndPostCondition {
    @BeforeTest
    public void beforeTestMethod(){
        System.out.println("I am before condition");
    }
    @AfterTest
    public void afterTestMethod(){
        System.out.println("I am after condition");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I'm before method which executes before every test");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I'm after method which executes after every test");
    }
    @Test
    public void firstTestCondition(){
        System.out.println("I am first test condition");
    }
    @Test
    public void secondTestCondition(){
        System.out.println("I am second test condition");
    }
}
