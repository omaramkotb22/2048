package com.example.demo;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Random;

class GameScene {

    private static final int HEIGHT = 500;

    public static int getN() {
        return n;
    }

    private static int n = 4; // Number of the of cells on each place of the block
    private static final int distanceBetweenCells = 10;
    private static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    private final TextMaker textMaker = TextMaker.getSingleInstance();


    private static Cell[][] cells = new Cell[n][n];

    public Group getRoot() {
        return root;
    }

    private Group root;
    private long score = 0;
    public static Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        GameScene.cells = cells;
    }


    /*
     * @param number
     * setting the number of blocks horizontally and vertically
     * setting the length of each cell according to the number of lines
     */
    static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }
    /*
     * @return length of the block
     */
    static double getLENGTH() {
        return LENGTH;
    }
    private int aForBound=0,bForBound=0;

    private void chooseCellBounds(Cell[][] emptyCells){
        int a = 0;
        int b = 0;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0) { // if cell is empty
                    emptyCells[a][b] = cells[i][j]; // set cell that has the position a and b to be the same cell that has the position
                    if (b < n-1) { // then, if b is less than n - 1 (3), it is going to set bForBound to whatever b is
                        bForBound=b;
                        b++;

                    } else {
                        aForBound=a;
                        a++;
                        b = 0;
                        if(a==n) // if a == n exit the loop
                            break outer;
                    }
                }
            }
        }

    }
    private void addRandomNumber(Cell[][] emptyCells){
        Text text;
        Random random = new Random();
        boolean putTwo = random.nextInt() % 2 != 0;
        // if the random number generated was divisible by 2
        int xCell, yCell;
        xCell = random.nextInt(aForBound+1);
        yCell = random.nextInt(bForBound+1);
        if (putTwo) {
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root); // add the number 2 on the empty cell if putTwo is true
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColor(2);
        } else {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColor(4);
        }

    }
    /*@param turn
     * */
    private void randomFillNumber(int turn) {
        Cell[][] emptyCells = new Cell[n][n]; // Create an array of arrays of cells, these will be the cells present on the block
        chooseCellBounds(emptyCells);
        addRandomNumber(emptyCells);
    }

    private void sumCellNumbersToScore() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                score += cells[i][j].getNumber();
            }
        }
    }
    void OptionsButton(Group root){
        Button optionsButton = new Button();
        GameSceneStyles.Button(optionsButton, "Options");
        optionsButton.setTranslateX(50);
        optionsButton.setTranslateY(540);
        optionsButton.setPrefSize(150, 50);
        optionsButton.setOnAction(e-> displayOptionPopup(root));
        optionsButton.setFocusTraversable(false);
        root.getChildren().add(optionsButton);
    }

    private void displayOptionPopup(Group root) {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        Button ResumeBtn = new Button();
        GameSceneStyles.Button(ResumeBtn,"Resume");
        vBox.getChildren().add(ResumeBtn);
        ResumeBtn.setOnAction(e->popup.close());
        Button MainMenuBtn = new Button();
        GameSceneStyles.Button(MainMenuBtn, "Main Manu");
        vBox.getChildren().add(MainMenuBtn);
        MainMenuBtn.setOnAction(e-> {
            try {
                ((Stage)root.getScene().getWindow()).close();
                new Controller().SwitchToMenu(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });
        MainMenuBtn.setFocusTraversable(false);
        vBox.setAlignment(Pos.CENTER);
        Scene popupScene = new Scene(vBox, 300,250);
        popup.setScene(popupScene);
        popup.showAndWait();
    }


    void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {

        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double locX = (j) * LENGTH + (j + 1) * distanceBetweenCells + 40;
                double locY = (i) * LENGTH + (i + 1) * distanceBetweenCells + 40;
                cells[i][j] = new Cell(locX,locY, LENGTH, root);
                cells[i][j].getRectangle().relocate(locX,locY);
                root.getChildren().add(cells[i][j].getRectangle());
            }


        }

        Text text = new Text();
        root.getChildren().add(text);
        text.setText("Score:");
        GameSceneStyles.ScoreText(text);
        text.relocate(50, 10);
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(140, 30);
        GameSceneStyles.ScoreText(scoreText);
        scoreText.setText("0");
        OptionsButton(root);
        randomFillNumber(1);
        randomFillNumber(1);

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key ->{
            Platform.runLater(() -> {
                int haveEmptyCell;
                if (key.getCode() == KeyCode.DOWN) {
                    EndGame.getInstance().endGameShow(endGameRoot, primaryStage, score);
                    Movements.moveDown();
                } else if (key.getCode() == KeyCode.UP) {
                    Movements.moveUp();
                } else if (key.getCode() == KeyCode.LEFT) {
                    Movements.moveLeft();
                } else if (key.getCode() == KeyCode.RIGHT) {
                    Movements.moveRight();
                }
                else {
                    return;
                }
                GameScene.this.sumCellNumbersToScore();
                scoreText.setText(score + "");
                haveEmptyCell = Checkers.haveEmptyCell();
                if (haveEmptyCell == -1) {
                    if (Checkers.canNotMove()) {
                        EndGame.getInstance().endGameShow(endGameRoot, primaryStage, score);
                        ((Stage) root.getScene().getWindow()).close();
                        ((Stage)endGameRoot.getScene().getWindow()).close();
//                        root.getChildren().clear();
                        score = 0;
                    }
                } else if(haveEmptyCell == 1)
                    GameScene.this.randomFillNumber(2);
            });
        });
    }
}