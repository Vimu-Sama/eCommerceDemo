package com.vimusama.eCommerceDemo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String showHomePage(){
        return ("Welcome to the E-Commerce Website!") ;
    }

    @RequestMapping("/about")
    public String aboutPage(){
        return ("The E-Commerce website offers variety of products, and to achieve its sole aim to bring every product at the customers doorstep!") ;
    }


}
