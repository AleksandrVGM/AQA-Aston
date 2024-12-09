package by.aston.figure;

public class Triangle extends Figure implements Square, Perimeter {
    private int height;
    private int base;
    private int side2;
    private int side3;

    public Triangle(int height, int base, int side2, int side3, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.height = height;
        this.base = base;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculatePerimeter() {
        return super.calculatePerimeterTriangle(base, side2, side3);
    }

    @Override
    public double calculateSquare() {
        return super.calculateSquareTriangle(height, base);
    }
}
