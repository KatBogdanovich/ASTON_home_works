package exemple;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static exemple.Main.*;
import static org.junit.jupiter.api.Assertions.*;

// Тесты к факториалу.

public class Tests {

    @ParameterizedTest
    @CsvSource({"7,5040", "9, 362880", "0, 1"})
    public void factorialTest(int param, int expected) {
        int result = factorial(param);
        assertEquals(expected, result, "Факториал расчитан неверно.");
    }

    @Test
    public void factorialNegativeTest() {
        assertThrows(IllegalArgumentException.class, () -> factorial(-7), "Ожидаемое исключение не получено.");
    }

    //Тесты к треугольнику.

    @ParameterizedTest
    @CsvSource({
            "5,8,20",
            "6,0,0"})
    public void triangleSquareTest(int a, int h, int expected) {
        double result = triangleSquare(a, h);
        assertEquals(expected, result, "Площадь расчитана неверно.");
    }

    @Test
    public void triangleSquareNegativeTest() {
        assertThrows(IllegalArgumentException.class, () -> triangleSquare(6, -3), "Некорректные данные.");
    }

    //Тесты к калькулятору.

    @ParameterizedTest
    @CsvSource({
            "20,4,/,5",
            "15,20,+,35",
            "10,3,-,7",
            "15,5,*,75"})
    public void calculatorTest(int a, int b, char x, int expected) {
        int result = calculator(a, b, x);
        assertEquals(expected, result, "Ожидание и результат не совпадают.");
    }

    @Test
    public void calculatorNegativeTest() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> calculator(7, 3, '#'), "Введен некорректный символ"),
                () -> assertThrows(ArithmeticException.class, () -> calculator(5, 0, '/'), "Деление на ноль")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "3,7,-1",
            "9,9,0",
            "11,7,1"})
    public void compareTest(int a, int b, int expected) {
        int result = compare(a, b);
        assertEquals(expected, result, "Сравнение чисел " + a + "и " + b + "прошло не корректно.");
    }
}
