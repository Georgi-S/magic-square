package com.example.firstrestapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibbonaciController {

    private InputAndButton inputAndButton = new InputAndButton();

    @GetMapping("/")
    public ResponseEntity<String> magicSquareForm() {
        return ResponseEntity.ok(inputAndButton.magicSquareForm());
    }
}
