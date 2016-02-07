package snake.model;

/**
 * Created by Yevhen on 05.02.2016.
 */
public interface Direction {
    Direction UP = element -> new SnakeElement(element.getX(), element.getY()-1);
    Direction RIGHT = element -> new SnakeElement(element.getX()+1, element.getY());
    Direction LEFT = element -> new SnakeElement(element.getX()-1, element.getY());
    Direction DOWN = element -> new SnakeElement(element.getX(), element.getY()+1);

    SnakeElement next(SnakeElement element);
}
