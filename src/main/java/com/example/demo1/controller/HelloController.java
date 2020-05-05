package com.example.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index(){
        return "hello";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required=false, defaultValue="World") String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }

}
