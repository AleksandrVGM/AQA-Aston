package by.aston.figure;

public class Rectangle extends Figure implements Square, Perimeter {
    private int length;
    private int width;

    public Rectangle(int length, int width, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return super.calculatePerimeterRectangle(length, width);
    }

    @Override
    public double calculateSquare() {
        return super.calculateSquareRectangle(length, width);
    }
}
