package com.amock.helloazure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthcheck")
public class NameListenController {

    @GetMapping(path = "/message")
    public String message(){
        return "Congrats ! your application deployed successfully in Azure Platform. !";
    }
}
