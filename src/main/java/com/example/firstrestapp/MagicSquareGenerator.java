package com.example.firstrestapp;

public class MagicSquareGenerator {

    public int[][] generate(int size) {
        int[][] magicSquare = new int[size][size];

        int number = 1;
        int row = 0;
        int col = size / 2;
        int currRow;
        int currCol;

        while (number <= size * size) {
            magicSquare[row][col] = number;
            number++;
            currRow = row;
            currCol = col;
            row -= 1;
            col += 1;

            if (row == -1) {
                row = size - 1;
            }
            if (col == size) {
                col = 0;
            }
            if (magicSquare[row][col] != 0) {
                row = currRow + 1;
                col = currCol;
                if (row == -1) {
                    row = size - 1;
                }
            }
        }
        return magicSquare;
    }
}
