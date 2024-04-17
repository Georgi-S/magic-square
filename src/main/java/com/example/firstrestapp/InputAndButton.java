package com.example.firstrestapp;

public class InputAndButton {
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
}
