package com.petis.debtapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class HomeController {

    //@PreAuthorize("hasRole('Admin')")
    @GetMapping()
    public String welcome(Principal principal) {
        return "Welcome!" + principal.getName();
    }
}
