package org.skypro.skyshop.controller;

import org.skypro.skyshop.error.ShopError;
import org.skypro.skyshop.exception.NoSuchProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {

    @ExceptionHandler (NoSuchProductException.class)
    public ResponseEntity<ShopError> noProduct(NoSuchProductException e) {
        ShopError shopError = new ShopError("NOT_FOUND", e.getMessage());
        return new ResponseEntity<>(shopError, HttpStatus.NOT_FOUND);
    }
}
