package com.example.demo;
public class Movements {
    private static final Cell[][] cells = GameScene.getCells();
    private static final int n = GameScene.getN();

    private static int passDestination(int i, int j, char direct) {
        int coordinate = j;
        if (direct == 'l') {
            return left(coordinate, i, j);
        }
        coordinate = j;
        if (direct == 'r') {
            return right(coordinate, i, j);
        }
        coordinate = i;
        if (direct == 'd') {
            return down(coordinate, i, j);
        }
        coordinate = i;
        if (direct == 'u') {
            return up(coordinate, i, j);
        }
        return -1;
    }
    private static int up(int coordinate, int i, int j){
        for (int k = i - 1; k >= 0; k--) {
            if (cells[k][j].getNumber() != 0) {
                coordinate = k + 1;
                break;
            } else if (k == 0) {
                coordinate = 0;
            }
        }
        return coordinate;
    }
    private static int down(int coordinate, int i, int j){
        for (int k = i + 1; k <= n - 1; k++) {
            if (cells[k][j].getNumber() != 0) {
                coordinate = k - 1;
                break;

            } else if (k == n - 1) {
                coordinate = n - 1;
            }
        }
        return coordinate;
    }
    private static int right(int coordinate, int i, int j){
        for (int k = j + 1; k <= n - 1; k++) {
            if (cells[i][k].getNumber() != 0) {
                coordinate = k - 1;
                break;
            } else if (k == n - 1) {
                coordinate = n - 1;
            }
        }
        return coordinate;
    }
    private static int left(int coordinate, int i, int j){
        for (int k = j - 1; k >= 0; k--) {
            if (cells[i][k].getNumber() != 0) {
                coordinate = k + 1;
                break;
            } else if (k == 0) {
                coordinate = 0;
            }
        }
        return coordinate;

    }
    private static void moveHorizontally(int i, int j, int des, int sign) {
        if (Checkers.isValidDesH(i, j, des, sign)) {
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des].setModify(true);
        } else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
        }
    }

    public static void moveLeft() {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                moveHorizontally(i, j, passDestination(i, j, 'l'), -1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    public static void moveDown() {
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                moveVertically(i, j, passDestination(i, j, 'd'), 1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }

    }
    private static void moveVertically(int i, int j, int des, int sign) {
        if (Checkers.isValidDesV(i, j, des, sign)) {
            cells[i][j].adder(cells[des + sign][j]);
            cells[des][j].setModify(true);
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
        }
    }
    public static void moveUp() {
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                moveVertically(i, j, passDestination(i, j, 'u'), -1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }

    }
    public static void moveRight() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                moveHorizontally(i, j, passDestination(i, j, 'r'), 1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }



}
