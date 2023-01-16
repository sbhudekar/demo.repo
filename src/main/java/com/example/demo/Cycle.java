package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class Cycle {
    @GetMapping("/mycycle")
    public String gettflightData(){
        return "Please book your cycle, Choose Your Fav cycle";
    }
}
