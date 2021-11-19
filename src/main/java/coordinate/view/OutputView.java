package coordinate.view;

import coordinate.shape.Line;
import coordinate.shape.Shape;
import coordinate.shape.Triangle;
import practice.coordinate.Coordinates;
import practice.type.Computable;
import practice.type.Type2;
import practice.type.Type3;

public class OutputView {
    public void result(Shape result) {
        String prefix = prefix(result);
        System.out.println(prefix + " : " + result.compute());
    }
    private String prefix(Shape result) {
        if(result instanceof Line) {
            return "두 점 사이 거리는";
        }
        if(result instanceof Triangle) {
            return "삼각형 넓이는";
        }
        return "사각형 넓이는";
    }
}
