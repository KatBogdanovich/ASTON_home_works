package exemple;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static exemple.Main.*;

public class TestClass {

    @Test(dataProvider = "factorialProvider")
    public void testFactorial(int f, int expected) {
        int result = factorial(f);
        Assert.assertEquals(expected, result, "Факториал расчитан неверно.");
    }

    @DataProvider
    private Object[][] factorialProvider() {
        return new Object[][]{
                {7, 5040},
                {9, 362880},
                {0, 1}
        };
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testNegativeFactorial(){
        factorial(-3);
    }

    @Test (dataProvider = "triangleSquareProvider")
    public void testTriangleSquare(int a, int h, int expected) {
        double result = triangleSquare(a, h);
        Assert.assertEquals(expected,result, "Площадь расчитана неверно.");
    }

    @DataProvider
    private Object[][] triangleSquareProvider(){
        return new Object[][]{
                {5, 8, 20},
                {6, 0, 0}
        };
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testNegativeTriangleSquare() {
        triangleSquare(6, -3);
    }

    @Test (dataProvider = "calculatorProvider")
    public void testCalculator(int a, int b, char x, int expected) {
        int result = calculator(a, b, x);
        Assert.assertEquals(expected, result, "Ожидание и результат не совпадают.");
    }

    @DataProvider
    private Object[][] calculatorProvider() {
        return new Object[][] {
                {20,4,'/',5},
                {15,20,'+',35},
                {10,3,'-',7},
                {15,5,'*',75}
        };
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testIllegalCalculatorSymbol() {
        calculator(7, 3, '#');
    }

    @Test(expectedExceptions = {ArithmeticException.class})
    public void testDivisionByZero() {
        calculator(5,0,'/');
    }

    @Test(dataProvider = "compareProvider")
    public void testCompare(int a, int b, int expected) {
        int result = compare(a, b);
        Assert.assertEquals(expected, result, "Сравнение чисел " + a + "и " + b + "прошло не корректно.");
    }

    @DataProvider
    private Object[][] compareProvider() {
        return new Object[][] {
                {3,7,-1},
                {9,9,0},
                {11,7,1}
        };
    }
}
