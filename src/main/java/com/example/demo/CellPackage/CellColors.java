package com.example.demo.CellPackage;

import javafx.scene.paint.Color;

import java.util.HashMap;
import javafx.scene.shape.Rectangle;
/**
 * This class represents the colors of the cells in the game.
 * It contains a {@link Rectangle} object that represents the visual representation of the cell.
 * The CellColors class has a method to change the color of the cell based on its number.
 */
public class CellColors {
    /**
     * Constructor for the CellColors class.
     * Takes the number and rectangle as arguments.
     * These values are used to initialize the {@link Rectangle} object of the CellColors.
     * @param number the number of the cell
     * @param rectangle the rectangle object of the cell
     */
    private final Rectangle rectangle;
    public CellColors(int number, Rectangle rectangle){
        this.rectangle = rectangle;
    }
    /**
     * Changes the color of the {@link Rectangle} object based on the given number.
     * The mapping of numbers to colors is stored in a {@link HashMap}.
     * @param number the number to use to determine the color of the rectangle.
     */
    public void setColorByNumber(int number){
        HashMap<Integer, float[]> colors = new HashMap<Integer, float[]>();
        colors.put(0, new float[]{206,245,254,(float) 1});
        colors.put(2, new float[]{182,240,254,(float) 1});
        colors.put(4, new float[]{158,235,254, (float) 1});
        colors.put(8, new float[]{134,230,254, (float) 1});
        colors.put(16, new float[]{109,225,253,(float) 1});
        colors.put(32, new float[]{85,220,253,(float) 1});
        colors.put(64, new float[]{61,215,253,(float) 1});
        colors.put(128, new float[]{37,210,253,(float) 1});
        colors.put(256, new float[]{13,205,253,(float) 1});
        colors.put(512, new float[]{11,184,227,(float) 1});
        colors.put(1024, new float[]{10,164,202,(float) 1});
        colors.put(2048, new float[]{9,143,177, (float) 1});
        float[] color = colors.get(number);
        rectangle.setFill(Color.rgb((int) color[0], (int) color[1], (int) color[2], color[3]));
    }
}
