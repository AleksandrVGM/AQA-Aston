package by.aston.figure;

public interface Perimeter {
    double calculatePerimeter();

    default double calculatePerimeterCircle(double radius) {
        return 2 * Math.PI * radius;
    }

    default double calculatePerimeterRectangle(double length, double width) {
        return 2 * (length + width);
    }

    default double calculatePerimeterTriangle(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }
}
