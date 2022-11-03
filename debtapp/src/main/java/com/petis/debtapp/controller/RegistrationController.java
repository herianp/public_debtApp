package com.petis.debtapp.controller;

import com.petis.debtapp.dto.LoginRequestDTO;
import com.petis.debtapp.dto.StatusDTO;
import com.petis.debtapp.dto.UserDTO;
import com.petis.debtapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<Object> registration(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new StatusDTO("ok"));
    }
}
