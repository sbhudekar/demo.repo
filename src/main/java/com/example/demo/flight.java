package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

    public class flight {
        @GetMapping("/myflight")
        public String gettflightData(){
            return "Please book your hhhh Train ticket, Choose Your Fav Express";
        }
}
