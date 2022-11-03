package com.petis.debtapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDTO {
    private String error;

    public ErrorDTO(String error) {
        this.error = error;
    }
}
