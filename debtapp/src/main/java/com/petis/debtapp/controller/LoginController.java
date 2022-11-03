package com.petis.debtapp.controller;

import com.petis.debtapp.dto.ErrorDTO;
import com.petis.debtapp.dto.LoginRequestDTO;
import com.petis.debtapp.dto.SuccessfulLoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/mylogin")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDTO loginData) {
        if (loginData.getUsername() == null || loginData.getPassword() == null || loginData.getUsername().equals("") || loginData.getPassword().equals("")) {
            return ResponseEntity.status(400).body(new ErrorDTO("Field username and/or field password was empty!"));
        }
        if (loginData.getPassword().length() < 8) {
            return ResponseEntity.status(401).body(new ErrorDTO("Username and/or password was incorrect!"));
        }
        return ResponseEntity.status(200).body(new SuccessfulLoginDTO("Logged in"));
    }
}
