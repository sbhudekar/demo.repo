package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class Boat {
    @GetMapping("/myboat")
    public String gettflightData(){
        return "Please book your hhhh Boat ticket, Choose Your Fav Boat";
    }
}
