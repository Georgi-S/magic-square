package com.example.firstrestapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
    
    @RestController
    public class MagicSquareController {
    
        @GetMapping("/ergebnis-magic")
        public ResponseEntity<String> getMagicSquare(@RequestParam(value = "size", defaultValue = "3") int size) {
            MagicSquareGenerator generator = new MagicSquareGenerator();
            int[][] square = generator.generate(size);
    
            StringBuilder builder = new StringBuilder("<table style='width:100%; border: 1px solid black;'>");
            for (int[] row : square) {
                builder.append("<tr>");
                for (int num : row) {
                    builder.append("<td style='border: 1px solid black; text-align: center;'>").append(num).append("</td>");
                }
                builder.append("</tr>");
            }
            builder.append("</table>");
            return ResponseEntity.ok(builder.toString());
        }
    }
    
