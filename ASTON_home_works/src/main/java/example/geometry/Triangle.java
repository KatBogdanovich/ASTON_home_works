package example.geometry;

public class Triangle implements Shape {
    private int a;
    private int b;
    private int c;
    private int height;
    private String fillingColor;
    private String borderColor;

    public Triangle(int a, int b, int c, int height, String fillingColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.height = height;
        this.fillingColor = fillingColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getSquare() {
        return (double) (c * height) / 2;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public void printInfo() {
        System.out.println("Треугольник");
        System.out.println("Периметр = " + getPerimeter());
        System.out.println("Площадь = " + getSquare());
        System.out.println("Цвет заливки фигуры = " + fillingColor);
        System.out.println("Цвет границы = " + borderColor);
        System.out.println();
    }
}
