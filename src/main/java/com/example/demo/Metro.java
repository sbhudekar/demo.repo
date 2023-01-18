package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class Metro {
    @GetMapping("/mymetro")
    public String gettrainData(){
        return "Please book your hhhh Train ticket, Choose Your Fav metro";
    }
}
