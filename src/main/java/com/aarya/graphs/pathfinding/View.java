package com.aarya.graphs.pathfinding;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.shape.*;
import org.w3c.dom.css.Rect;

import java.util.Random;

public class View extends Application {

    public final static int rows = 10;
    public final static int cols = 10;
    public final static int blockSize = 40;
    public final static int grid_w = cols * blockSize;
    public final static int grid_h = rows * blockSize;

    public final static Color unvisited_clr = Color.WHITESMOKE;
    public final static Color visited_clr = Color.LAVENDER;
    public final static Color obstacle_clr = Color.SADDLEBROWN;
    public final static Color exploring_clr = Color.YELLOWGREEN;
    public final static Color marker_clr = Color.PALEVIOLETRED;

    protected GridPane container;
    protected Rectangle[][] grid = new Rectangle[rows][cols];

    Random random = new Random();

    protected Rectangle startBlock;
    protected Rectangle finishBlock;

    @Override
    public void start(Stage primaryStage) throws Exception {
        container = new GridPane();

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                grid[x][y] = createBlock(x, y);
                container.add(grid[x][y], y, x);
            }
        }
        startBlock = grid[random.nextInt(rows)][random.nextInt(cols)];
        finishBlock = grid[random.nextInt(rows)][random.nextInt(cols)];
        startBlock.setFill(marker_clr);
        finishBlock.setFill(marker_clr);

        Scene scene = new Scene(container, grid_w + cols, grid_h + rows);

        primaryStage.setTitle("Pathfinder");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private Rectangle createBlock(int col, int row) {
        Rectangle r = new Rectangle(col * blockSize, row * blockSize, blockSize, blockSize);
        r.setStroke(Color.GRAY);
        r.setFill(unvisited_clr);
        return r;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}