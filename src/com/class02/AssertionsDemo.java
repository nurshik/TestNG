package com.class02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
    @Test
    public void assertVerification(){
        String expectedtext="Software Testing";
        String actualText="Software Testing";
        System.out.println("My receiving text is "+expectedtext);
        //Assert.assertTrue(false);
        Assert.assertFalse(false);
        Assert.assertEquals(expectedtext,actualText);
        System.out.println("My test is passed");

    }
}
