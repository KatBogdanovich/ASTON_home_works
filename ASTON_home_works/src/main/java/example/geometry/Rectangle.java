package example.geometry;

public class Rectangle implements Shape {
    private int a;
    private int b;
    private String fillingColor;
    private String borderColor;

    public Rectangle(int a, int b, String fillingColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.fillingColor = fillingColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getSquare() {
        return (double) a * b;
    }

    @Override
    public double getPerimeter() {
        return (double) (a + b) * 2;
    }

    @Override
    public void printInfo() {
        System.out.println("Прямоугольник");
        System.out.println("Периметр = " + getPerimeter());
        System.out.println("Площадь = " + getSquare());
        System.out.println("Цвет заливки фигуры = " + fillingColor);
        System.out.println("Цвет границы = " + borderColor);
        System.out.println();
    }
}

