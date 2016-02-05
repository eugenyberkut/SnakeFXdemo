package snake.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import snake.model.SnakeGame;

/**
 * Created by Yevhen on 05.02.2016.
 */
public class GameView {
    private SnakeGame game;
    private Canvas canvas;

    public GameView(SnakeGame game, Canvas canvas) {
        this.canvas = canvas;
        this.game = game;
    }

    public void draw() {
        clear();
        drawField();
    }

    private void drawField() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.strokeLine(0,0,canvas.getWidth(),canvas.getHeight());
        gc.strokeLine(canvas.getWidth(),0,0,canvas.getHeight());
    }

    private void clear() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }
}
