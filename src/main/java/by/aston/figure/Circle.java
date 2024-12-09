package by.aston.figure;

public class Circle extends Figure implements Square, Perimeter {
    private double radius;

    public Circle(double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return super.calculatePerimeterCircle(radius);
    }

    @Override
    public double calculateSquare() {
        return super.calculateSquareCircle(radius);
    }
}
