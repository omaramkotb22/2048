package com.example.demo.CellPackage;


import com.example.demo.TextMaker;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/*
 * This Class handles the Cells on the board
 */

public class Cell {
    private Rectangle rectangle;
    private Group root;
    private double x;
    private double y;
    private double scale;

    public Text textClass;
    private boolean modify = false;

    /*
     * @param modify to be set
     */
    public void setModify(boolean modify) {
        this.modify = modify;
    }

    /*
     * @return true if the cell has been modified
     * */
    public boolean getModify() {
        return modify;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    /*
     * Constructor for the Cell class
     * @param x is the width of the block
     * */
    public Cell(double x, double y, double scale, Group root) { // Constructor for the Cell class, takes the width of the cell x the height of the cell y, the score on the Cell scale, and the group root
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        this.root = root;
        rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);

    }
    /*
     * @param textClass
     */
    public void setTextClass(Text textClass) {
        this.textClass = textClass;
    }
    public void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.getTextClass());
        root.getChildren().remove(cell.getTextClass());
        root.getChildren().remove(textClass);

        if (!cell.getTextClass().getText().equals("0")) {
            root.getChildren().add(cell.getTextClass());
        }
        if (!textClass.getText().equals("0")) {
            root.getChildren().add(textClass);
        }
        setColor(getNumber());
        cell.setColor(cell.getNumber());
    }

    public void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColor(cell.getNumber());
        setColor(getNumber());
    }

    public void setColor(int number) {
        new CellColors(number, rectangle).setColorByNumber(number);
        }



    public double getX() {
        return rectangle.getX();
    }

    public double getY() {
        return rectangle.getY();
    }

    public int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    public Text getTextClass() {
        return textClass;
    }

}
