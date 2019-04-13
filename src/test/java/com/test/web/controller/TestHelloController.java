package com.test.web.controller;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class TestHelloController {
    HelloWorldController  helloWorldController = null;
    @Before
    public void setup(){
        helloWorldController = new HelloWorldController();
    }
    @Test
    public void hello(){
        String strHello = helloWorldController.helloworld();
        System.out.println(strHello);
        Assert.assertTrue(strHello.equals("Hello, World!"));
    }
}
