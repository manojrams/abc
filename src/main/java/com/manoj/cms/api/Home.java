package com.manoj.cms.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller //// This class is to make sure we dont see white error page when we open the URL
public class Home {
    @GetMapping
    public String Home(){
        return "index" ;
    }
}
