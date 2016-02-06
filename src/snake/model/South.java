package snake.model;

/**
 * Created by Yevhen on 05.02.2016.
 */
public class South implements Direction {
    @Override
    public SnakeElement next(SnakeElement element) {
        return new SnakeElement(element.getX(), element.getY()+1);
    }
}
