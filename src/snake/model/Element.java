package snake.model;

import java.util.Objects;

/**
 * Created by Yevhen on 05.02.2016.
 */
public class Element {
    private int x;
    private int y;

    public Element(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element = (Element) o;
        return x == element.x &&
                y == element.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
