package com.gil.springboot.service.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// make a Get method of field declared
// make a constructor include the final field
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

}