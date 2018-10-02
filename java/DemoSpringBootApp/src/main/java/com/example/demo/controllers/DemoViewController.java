package com.example.demo.controllers;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/demo")
public class DemoViewController {

    static Logger log = Logger.getLogger(DemoViewController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String doShow() {
        return "demo";
    }

}
