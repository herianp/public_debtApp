package com.petis.debtapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class StatusDTO {
    private String status;

    public StatusDTO(String status) {
        this.status = status;
    }
}
