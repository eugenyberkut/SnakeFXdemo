package snake.model;

/**
 * Created by Yevhen on 05.02.2016.
 */
public class East implements Direction {
    @Override
    public SnakeElement next(SnakeElement element) {
        return new SnakeElement(element.getX()+1, element.getY());
    }
}
