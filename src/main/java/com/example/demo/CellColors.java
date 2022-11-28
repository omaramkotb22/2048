package com.example.demo;

import javafx.scene.paint.Color;

import java.util.HashMap;
import javafx.scene.shape.Rectangle;

public class CellColors {
    private int number;
    private Rectangle rectangle;
    public CellColors(int number, Rectangle rectangle){
        this.number = number;
        this.rectangle = rectangle;
    }
    public void setColorByNumber(int number){
        HashMap<Integer, float[]> colors = new HashMap<Integer, float[]>();
        colors.put(0, new float[]{224, 226, 226,(float) 0.5});
        colors.put(2, new float[]{232, 255, 100,(float) 0.5});
        colors.put(4, new float[]{232, 220, 50, (float) 0.5});
        colors.put(8, new float[]{232, 200, 44, (float)0.8});
        colors.put(16, new float[]{232, 170, 44,(float) 0.8});
        colors.put(32, new float[]{180, 120, 44,(float) 0.7});
        colors.put(64, new float[]{180, 100, 44,(float) 0.7});
        colors.put(128, new float[]{180, 80, 44,(float) 0.7});
        colors.put(256, new float[]{180, 60, 44,(float) 0.8});
        colors.put(512, new float[]{180, 30, 44,(float) 0.8});
        colors.put(1024, new float[]{250, 0, 44,(float) 0.8});
        colors.put(2048, new float[]{250, 0, 0, (float) 1});
        float[] color = colors.get(number);
        rectangle.setFill(Color.rgb((int) color[0], (int) color[1], (int) color[2], color[3]));
    }
}
