package com.example.firstrestapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class FibbonaciController {

//     @GetMapping("/ergebnis")
// public String fibbo() {
//     return "Ergebnis";
// }


@GetMapping("/")
    public String magicSquareForm() {
        return "<html>" +
               "<body>" +
               "<form action='/ergebnis-magic' method='GET'>" +
               "Geben Sie die Größe des magischen Quadrats ein: <input type='number' name='size' required>" +
               "<button type='submit'>Erzeugen</button>" +
               "</form>" +
               "</body>" +
               "</html>";
    }

@GetMapping("/ergebnis-magic")
public String getMagicSquare(@RequestParam(value = "size", defaultValue = "3") int size ) {
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
    return builder.toString();

}


}

