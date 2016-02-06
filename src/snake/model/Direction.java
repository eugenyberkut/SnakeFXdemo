package snake.model;

/**
 * Created by Yevhen on 05.02.2016.
 */
public interface Direction {
    Direction UP = new North();
    Direction RIGHT = new East();
    Direction LEFT = new West();
    Direction DOWN = new South();

    SnakeElement next(SnakeElement element);
}
