package com.test.web.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ReplyController {
    @RequestMapping("/reply")
    public String reply(String name){
            return "Hello, " + name;
        }
    }


