package by.aston.figure;

public interface Square {
    double calculateSquare();

    default double calculateSquareCircle(double radius) {
        return Math.PI * radius * radius;
    }

    default double calculateSquareRectangle(double length, double width) {
        return length * width;
    }

    default double calculateSquareTriangle(double height, double base) {
        return 0.5 * height * base;
    }
}
