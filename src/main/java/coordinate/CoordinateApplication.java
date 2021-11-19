package coordinate;

import coordinate.point.Points;
import coordinate.shape.Shape;
import coordinate.shape.ShapeFactory;
import coordinate.util.StringParser;
import coordinate.view.InputVIew;
import coordinate.view.OutputView;

public class CoordinateApplication {
    public static void main(String[] args) {
        InputVIew inputVIew = new InputVIew();
        OutputView outputView = new OutputView();

        inputVIew.init();
        String input = inputVIew.input();

        Points points = StringParser.parse(input);
        Shape shape = ShapeFactory.create(points);
        outputView.result(shape);
    }
}
