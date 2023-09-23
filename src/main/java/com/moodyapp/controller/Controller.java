package com.moodyapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/accounts")
    public void getExistingAccounts() {
        
    }

}
