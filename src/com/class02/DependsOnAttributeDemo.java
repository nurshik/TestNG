package com.class02;

import org.testng.annotations.Test;

public class DependsOnAttributeDemo {
    @Test
    public void loginTest(){
        System.out.println("Login test");
    }
    @Test(dependsOnMethods = "loginTest")
    public void enterCredentials(){
        System.out.println("Dependent Method");
    }
}
