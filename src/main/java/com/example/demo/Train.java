package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class Train {
    @GetMapping("/myflight")
    public String gettrainData(){
        return "Please book your hhhh Train ticket, Choose Your Fav Express";
    }
}
