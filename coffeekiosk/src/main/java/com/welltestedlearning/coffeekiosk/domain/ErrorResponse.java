package com.welltestedlearning.coffeekiosk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    int statusCode;
    String message;
}
