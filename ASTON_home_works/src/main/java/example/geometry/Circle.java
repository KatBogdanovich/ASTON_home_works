package example.geometry;

public class Circle implements Shape {
    private int r;
    private String fillingColor;
    private String borderColor;

    public Circle(int r, String fillingColor, String borderColor) {
        this.r = r;
        this.fillingColor = fillingColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getSquare() {
        return (double)Math.PI*r*r;
    }

    @Override
    public double getPerimeter() {
        return (double) 2*Math.PI*r;
    }

    @Override
    public void printInfo() {
        System.out.println("Круг");
        System.out.println("Окружность = " + getPerimeter());
        System.out.println("Площадь = " + getSquare());
        System.out.println("Цвет заливки фигуры = " + fillingColor);
        System.out.println("Цвет границы = " + borderColor);
        System.out.println();
    }
}
