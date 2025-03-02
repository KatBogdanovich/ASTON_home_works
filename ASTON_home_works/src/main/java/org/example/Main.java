package org.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkSumNumbers(-45, 60));
        checkNumberNegativeOrPositive(-8);
        System.out.println(isNumberNegative(0));
        printLineNTimes("Хорошего дня!", 3);
        System.out.println(isYearLeap(900));
        replacementElement();
        fillArr();
        modifiedArray();
        fillDiagonal(7);
        createArr(8, 10);
    }

    /*
   1.Создайте метод printThreeWords(), который при вызове должен отпечатать
    в столбец три слова: Orange, Banana, Apple.
   */
    public static void printThreeWords() {
        System.out.println(" ");
        System.out.println("Задание №1");
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    /*
    2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и
    инициализируйте их любыми значениями, которыми захотите. Далее метод должен просуммировать
    эти переменные, и если их сумма больше или равна 0, то вывести в консоль сообщение
    "Сумма положительная", в противном случае - "Сумма отрицательная".
     */
    public static void checkSumSign() {
        System.out.println(" ");
        System.out.println("Задание №2");
        int a, b;
        a = 15;
        b = 4;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    /*
    3. Создайте метод  printColor() в теле которого задайте int переменную value и
    инициализируйте ее любым значением. Если value меньше 0 (0 включительно), то в консоль
    метод должен вывести сообщение "Красный", если лежит в пределах от 0 (0 исключительно) до
    100 (100 включительно), то "Желтый", если больше 100 (100 исключительно) - "Зеленый".
     */
    public static void printColor() {
        System.out.println(" ");
        System.out.println("Задание №3");
        int value = 156;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    /*
    4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и
    инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b, то
    необходимо вывести в консоль сообщение "a>=b", в противном случае "a<b".
     */
    public static void compareNumbers() {
        System.out.println(" ");
        System.out.println("Задание №4");
        int a = 7;
        int b = 7;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    /*
    5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
    в пределах от 10 до 20 (включительно), если да - вернуть true, в противном случае - false.
     */
    public static boolean checkSumNumbers(int k, int r) {
        System.out.println(" ");
        System.out.println("Задание №5");
        if ((k + r) > 10 & (k + r) <= 20) {
            return true;
        } else {
            return false;
        }
    }

    /*
    6. Напишите метод, которому в качестве параметра передается целое число, метод должен
    напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль
    считаем положительным числом.
     */
    public static void checkNumberNegativeOrPositive(int s) {
        System.out.println(" ");
        System.out.println("Задание №6");
        if (s < 0) {
            System.out.println("Отрицательное");
        } else {
            System.out.println("Положительное");
        }
    }

    /*
    7.Напишите метод, которому в качестве параметра передается целое число. Метод должен
    вернуть true, если число отрицательное, и вернуть false если положительное. Замечание:
    ноль считаем положительным числом.
     */
    public static boolean isNumberNegative(int t) {
        System.out.println(" ");
        System.out.println("Задание №7");
        if (t < 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
    8. Напишите метод, которому в качестве аргументов передается строка и число, метод
    должен отпечатать в консоль указанную строку, указанное количество раз.
     */
    public static void printLineNTimes(String line, int n) {
        System.out.println(" ");
        System.out.println("Задание №8");
        for (int z = 1; z <= n; z++) {
            System.out.println(line);
        }
    }

    /*
    9. Напишите метод, который определяет, является ли год високосным, и возвращает boolean
     (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме
     каждого 100-го, при этом каждый 400-й - високосный.
     */
    public static boolean isYearLeap(int year) {
        System.out.println(" ");
        System.out.println("Задание №9");
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        if (year % 4 == 0)
            return true;
        return false;
    }

    /*
    10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
    [1, 1, 0, 0, 1, 0, 1, 1, 0, 0]. С помощью цикла и условия заменить 0 на 1, 1 на 0.
     */
    public static void replacementElement() {
        System.out.println(" ");
        System.out.println("Задание №10");
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                arr[i] = 0;
            else
                arr[i] = 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    /*
    11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его
    значениями 1 2 3 4 5 6 7 8 ... 100.
     */
    public static void fillArr() {
        System.out.println(" ");
        System.out.println("Задание №11");
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    /*
    12. Задать массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1] пройти по нему циклом, и числа
    меньше 6 умножить на 2.
     */
    public static void modifiedArray() {
        System.out.println(" ");
        System.out.println("Задание №12");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /*
    13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
    одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно
    только одну из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно
    по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ...,
    [n][n].
     */
    public static void fillDiagonal(int n) {
        System.out.println(" ");
        System.out.println("Задание №13");
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j | j == n - 1 - i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /*
    14. Написать метод, принимающий на вход два аргумента: len и  initialValue, и возвращающий
    одномерный массив типа int длиной len, каждая ячейка, которого равна initialValue.
     */
    public static void createArr(int len, int initialValue) {
        System.out.println(" ");
        System.out.println("Задание №14");
        int[] arr = new int[len];
        for (int i : arr) {
            i = initialValue;
            System.out.print(i + "  ");
        }
    }
}
