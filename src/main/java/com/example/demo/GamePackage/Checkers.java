package com.example.demo.GamePackage;


import com.example.demo.CellPackage.Cell;
/**
 * This class contains methods for checking the game conditions and validating the movement of cells.
 * It has methods for checking if there is an empty cell or if the cells cannot move, and methods for validating the destination of cells when they are moved horizontally or vertically.
 */

public class Checkers {
    private static final Cell[][] cells = GameScene.getCells();
    private static final int n = GameScene.getN();
    /**
     * Determines if there is an empty cell in the game.
     *
     * @return 1 if there is an empty cell, 0 if there is a cell with a value of 2048, and -1 if there are no empty cells or cells with a value of 2048
     */
    public static int  haveEmptyCell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0)
                    return 1;
                if(cells[i][j].getNumber() == 2048)
                    return 0;
            }
        }
        return -1;
    }
    /**
     * returns if the cells cannot move.
     *
     * @return true if the cells cannot move, else false.
     */
    public static boolean canNotMove() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Determines if the cells have the same number as the cell adjacent to it.
     *
     * @param i the row index of the cell
     * @param j the column index of the cell
     * @return true if the cells have the same number as the cell adjacent to it, false otherwise
     */
    private static boolean haveSameNumberNearly(int i, int j) {
        if (i < n - 1 && j < n - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            return cells[i][j + 1].getNumber() == cells[i][j].getNumber();
        }
        return false;
    }
    /**
     * Determines if the destination cell can move horizontally.
     *
     * @param i the row index of the current cell
     * @param j the column index of the current cell
     * @param des the column index of the destination cell
     * @param sign -1 if left, 1 if right the direction of the move
     * @return true if the destination cell is a valid destination for moving horizontally, else false
     */
    public static boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0) {
            return cells[i][des + sign].getNumber() == cells[i][j].getNumber() && !cells[i][des + sign].getModify()
                    && cells[i][des + sign].getNumber() != 0;
        }
        return false;
    }
    /**
     * Determines if the destination cell can move horizontally.
     *
     * @param i the row index of the current cell
     * @param j the column index of the current cell
     * @param des the column index of the destination cell
     * @param sign -1 if left, 1 if right the direction of the move
     * @return true if the destination cell is a valid destination for moving horizontally, else false
     */
    public static boolean isValidDesV(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0)
            return cells[des + sign][j].getNumber() == cells[i][j].getNumber() && !cells[des + sign][j].getModify()
                    && cells[des + sign][j].getNumber() != 0;
        return false;
    }



}
