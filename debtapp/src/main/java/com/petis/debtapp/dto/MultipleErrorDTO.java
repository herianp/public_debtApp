package com.petis.debtapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class MultipleErrorDTO {
    private String status;
    private List<String> messages;
}
