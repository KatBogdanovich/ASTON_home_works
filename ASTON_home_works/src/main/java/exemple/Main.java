package exemple;

public class Main {

    public static int factorial(int f) {
        if (f < 0) throw new IllegalArgumentException("Передано некорректное значение.");
        int factorial = 1;
        for (int i = 1; i <= f; i++) {
            factorial = factorial * i;
        }
        System.out.println("Факториал числа " + f + " = " + factorial);
        return factorial;
    }

    public static double triangleSquare(int a, int h) {
        if (a < 0 || h < 0) throw new IllegalArgumentException("Параметры треугольника не могут быть отрицательными.");
        double sTriangle = (a * h) * 1.0 / 2;
        System.out.println("Площадь треугольника, где\n" + "сторона = " + a + ", а высота = " + h + "\nсоставляет = " + sTriangle);
        return sTriangle;
    }

    public static int calculator(int a, int b, char x) {
        int result;
        switch (x) {
            case '+': {
                result = a + b;
                System.out.println("Сумма = " + result);
                break;
            }
            case '-': {
                result = a - b;
                System.out.println("Разность = " + result);
                break;
            }
            case '*': {
                result = a * b;
                System.out.println("Произведение = " + result);
                break;
            }
            case '/': {
                result = a / b;
                System.out.println("Деление = " + result);
                break;
            }
            default:
                throw new IllegalArgumentException("Передан некорректный символ.");
        }
        return result;
    }

    public static int compare(int a, int b) {
        int result;
        if (a > b) {
            result = 1;
            System.out.println(" " + a + " больше " + b + ".");
        } else if (a < b) {
            result = -1;
            System.out.println(" " + a + " меньше " + b + ".");
        } else {
            result = 0;
            System.out.println(" " + a + " равно " + b + ".");
        }
        return result;
    }
}
