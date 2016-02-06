package snake.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yevhen on 05.02.2016.
 */
public class Snake {
    private Direction direction;
    private LinkedList<SnakeElement> body;
    private SnakeElement head;

    public Snake(int initialLength) {
        head = new SnakeElement(SnakeGame.SIZE_XY/2, SnakeGame.SIZE_XY/2);
        body = new LinkedList<>();
        for (int i = 1; i < initialLength; i++) {
            body.add(new SnakeElement(SnakeGame.SIZE_XY/2, SnakeGame.SIZE_XY/2+i));
        }
        direction = Direction.UP;
    }

    public List<SnakeElement> getBody() {
        return body;
    }

    public SnakeElement getHead() {
        return head;
    }

    public void move() {
        body.addFirst(head);
        head = direction.next(head);

        body.removeLast();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
