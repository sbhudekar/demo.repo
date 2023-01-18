package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class Riksha {
    @GetMapping("/myriksha")
    public String gettrainData(){
        return "Please book your hhhh Train ticket, Choose Your Fav Riksha";
    }
}
