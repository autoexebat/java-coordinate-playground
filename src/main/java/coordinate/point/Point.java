package coordinate.point;

import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        validate(x, y);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void validate(int x, int y) {
        boolean invalidX = x < 0 || x > 24;
        boolean invalidY = y < 0 || y > 24;
        if(invalidX || invalidY) {
            throw new IllegalArgumentException("범위를 벗어났습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
