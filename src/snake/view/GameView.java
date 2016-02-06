package snake.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import snake.model.Element;
import snake.model.SnakeElement;
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
        gc.setStroke(Color.BEIGE);
//        gc.strokeLine(0,0,canvas.getWidth(),canvas.getHeight());
//        gc.strokeLine(canvas.getWidth(),0,0,canvas.getHeight());
        double size = Math.min(canvas.getHeight(),canvas.getWidth());
        double scale = SnakeGame.CELL_SIZE * SnakeGame.SIZE_XY / size;
        for (int i = 0; i < SnakeGame.SIZE_XY; i++) {
            gc.strokeLine(0,i*SnakeGame.CELL_SIZE/scale, size, i*SnakeGame.CELL_SIZE/scale);
            gc.strokeLine(i*SnakeGame.CELL_SIZE/scale, 0, i*SnakeGame.CELL_SIZE/scale, size);
        }
        gc.setStroke(Color.BLACK);
        gc.strokeRect(0,0,size,size);
        drawHead(gc, scale);
        drawBody(gc, scale);
        drawApple(gc, scale);
    }

    private void drawApple(GraphicsContext gc, double scale) {
        drawElement(gc, scale, game.getApple(), Color.GREEN);
    }

    private void drawBody(GraphicsContext gc, double scale) {
        for (SnakeElement element: game.getSnake().getBody()) {
            drawElement(gc,scale, element, Color.BLUE);
        }
    }

    private void drawHead(GraphicsContext gc, double scale) {
        drawElement(gc, scale, game.getSnake().getHead(), Color.RED);
    }

    private void drawElement(GraphicsContext gc, double scale, Element element, Color color) {
        gc.setFill(color);
        gc.fillOval(element.getX()* SnakeGame.CELL_SIZE/scale, element.getY()*SnakeGame.CELL_SIZE/scale, SnakeGame.CELL_SIZE/scale, SnakeGame.CELL_SIZE/scale);
    }

    private void clear() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }
}
