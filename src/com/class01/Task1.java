package com.class01;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task1 {
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @Test
    public void test3(){
        System.out.println("Test 3");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After test");
    }
}
