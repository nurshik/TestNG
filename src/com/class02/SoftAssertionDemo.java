package com.class02;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionDemo {
    @Test
    public void softAssertionValidation(){
        String expectedText="Testing world";
        String actualText="Testing World";

        SoftAssert soft=new SoftAssert();
        soft.assertEquals(expectedText,actualText);
        System.out.println("My code after first assertion");

        soft.assertTrue(false);
        System.out.println("My code after second assertion");

        soft.assertFalse(true);
        System.out.println("My code after third assertion");

        String expectedText2="Testing world";
        String actualText2="Testing world";

        soft.assertEquals(expectedText2,actualText2);
        System.out.println("My code after 4th assertion");
        soft.assertAll();

    }
}
