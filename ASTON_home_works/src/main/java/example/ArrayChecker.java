package example;

public class ArrayChecker {

    public static int checkArraySize(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int legalSize = 4;
        if (arr.length != legalSize || arr[0].length != legalSize) {
            throw new MyArraySizeException("Не верный размер массива. Размер массива не равен 4x4.");
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Некорректное значение данных в ячейке [" + i + "][" + j + "].");
                }
            }
        }
        return sum;
    }
}
