package snake.model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.Random;

/**
 * Created by Yevhen on 05.02.2016.
 */
public class SnakeGame {

    public final static int CELL_SIZE = 15;
    public final static int SIZE_XY = 50;
    private Random rnd = new Random();


    private boolean running = true;
    private Snake snake;
    private Apple apple;

    public SnakeGame() {
        snake = new Snake(5);
        newApple(snake);
    }

    private void newApple(Snake snake) {
        do {
            apple = new Apple(rnd.nextInt(SIZE_XY), rnd.nextInt(SIZE_XY));
        } while (getSnake().getHead().equals(apple) || snake.getBody().stream().anyMatch(e->e.equals(apple)));
    }

    public Snake getSnake() {
        return snake;
    }

    public Apple getApple() {
        return apple;
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public void tick() {
        if (running) {
            snake.move();
        }
    }

    public void turnSnake(Direction direction) {
        snake.setDirection(direction);
    }
}
