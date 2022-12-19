package com.example.demo.CellPackage;


import com.example.demo.TextMaker;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**

 * This class represents a Cell in GameScene Class.
 * It contains a {@link Rectangle} object and a {@link Text} object that represent the Cell in the grid.
 * It also has a {@link Group} object that represents the root of the scene graph.

 * The Cell class has methods to change its text, color, and modify status.
 */

public class Cell {
    private final Rectangle rectangle;
    private final Group root;

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

    /**
     *
     * @return Rectangle
     */
    public Rectangle getRectangle() {
        return rectangle;
    }

    /**
     Constructor for the Cell class.
     Takes the x coordinate, y coordinate, scale, and root as arguments.
     These values are used to initialize the {@link Rectangle} and {@link Text} objects of the Cell.
     @param x the x coordinate of the cell
     @param y the y coordinate of the cell
     @param scale the scale of the cell
     @param root the root of the scene graph
     */
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

    public void setTextClass(Text textClass) {
        this.textClass = textClass;
    }
    /**
     Changes the {@link Text} object of the current Cell to the {@link Text} object of the given Cell.

     Also removes the {@link Text} objects from the root and adds them back if their text is not "0".

     @param cell the Cell whose {@link Text} object will be set to the current Cell's {@link Text} object
     */
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
    /**
     Adds the integer value of the {@link Text} object of the current Cell to the value of the {@link Text} object of the given Cell.
     Sets the {@link Text} object of the current Cell to "0" and removes it from the root if its text is not "0".
     @param cell the Cell whose {@link Text} object's value will be added to the current Cell's {@link Text} object's value
     */
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

    public void setNumber(int i) {
        textClass.setText(String.valueOf(i));
    }
}
