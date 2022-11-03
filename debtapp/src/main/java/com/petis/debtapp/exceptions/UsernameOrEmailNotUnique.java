package com.petis.debtapp.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class UsernameOrEmailNotUnique extends RuntimeException {
    List<String> messages;

    public UsernameOrEmailNotUnique(List<String> messages) {
        this.messages = messages;
    }
}
