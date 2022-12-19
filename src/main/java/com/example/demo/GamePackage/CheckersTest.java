package com.example.demo.GamePackage;

import com.example.demo.CellPackage.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckersTest {

    @Test
    void haveEmptyCell() {
        int n = 4;
        Cell[][] cells = new Cell[n][n];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells[i][j] = new Cell(0, 0, 0, null);
                cells[i][j].setNumber(0);

            }
        }

        // Test with all cells having a value of 0
        int result = Checkers.haveEmptyCell();
        assertEquals(1, result, "Failed test for all cells having a value of 0");

        // Test with one cell having a value of 2048
        cells[0][0].setNumber(2048);
        result = Checkers.haveEmptyCell();
        assertEquals(0, result, "Failed test for one cell having a value of 2048");

        // Test with all cells having a non-zero value
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells[i][j].setNumber(2);
            }
        }
        result = Checkers.haveEmptyCell();
        assertEquals(-1, result, "Failed test for all cells having a non-zero value");
    }


    @Test
    void canNotMove() {

    }

    @Test
    void isValidDesH() {
    }

    @Test
    void isValidDesV() {
    }
}