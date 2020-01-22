package com.manoj.cms.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller // here restcontroller acts as @component
public class HelloWorld {

    @GetMapping(value="/hello")
    //i am mapping the url , here when I use / hello below method is trigeered and output is returned in browser
    public String sayHello(){

        return "hello";
    }
}
