package by.aston.figure;

public abstract class Figure implements Square, Perimeter {
    protected String fillColor;
    protected String borderColor;

    public Figure(String fillColor, String borderColor) {
        super();
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public abstract double calculatePerimeter();

    @Override
    public abstract double calculateSquare();
}
