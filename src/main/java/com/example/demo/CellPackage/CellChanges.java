package com.example.demo.CellPackage;

import com.example.demo.TextMaker;
import javafx.scene.Group;

public class CellChanges extends Cell{
    
    private Group root;
    private double x;
    private double y;
    private double scale;
    CellChanges(double x, double y, double scale, Group root) {
        super(x, y, scale, root);
        this.root = root;
        this.x = x;
        this.y = y;
        this.scale = scale;


    }
    public void changeCell(Cell cell) {
        TextMaker.changeTwoText(cell.getTextClass(), cell.getTextClass());
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



}
