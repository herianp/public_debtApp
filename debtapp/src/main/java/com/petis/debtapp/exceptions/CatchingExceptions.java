package com.petis.debtapp.exceptions;

import com.petis.debtapp.dto.ErrorDTO;
import com.petis.debtapp.dto.MultipleErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class CatchingExceptions {

    @ExceptionHandler(PasswordTooShortException.class)
    public static ResponseEntity<ErrorDTO> passwordTooShort() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("Incorrect password format!"));
    }

    // prepared for email
//    @ExceptionHandler(InvalidEmailFormatException.class)
//    public static ResponseEntity<ErrorDTO> invalidEmailFormat() {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("Incorrect email format!"));
//    }

    @ExceptionHandler(UsernameOrEmailNotUnique.class)
    public static ResponseEntity<MultipleErrorDTO> usernameAndEmailAlreadyExists(UsernameOrEmailNotUnique e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MultipleErrorDTO("error", e.getMessages()));
    }
}
