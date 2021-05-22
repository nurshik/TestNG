package com.class02;

import org.testng.annotations.Test;

public class PriorityDemo {
    @Test(priority = 2)
    public void firstMethod(){
        System.out.println("This should be second");
    }
    @Test(priority = 1)
    public  void secondMethod(){
        System.out.println("This should be first");
    }
    @Test(priority = 3)
    public void thirdmethod(){
        System.out.println("This should be third");
    }

}
