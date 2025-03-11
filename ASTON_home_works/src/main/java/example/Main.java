package example;

public class Main {
    public static void main(String[] args) {
        String[][] ilLegalSizeArray = new String[4][6];
        String[][] ilLegalValueArray = new String[][]{
                {"6", "2", "5", "1"},
                {"1", "2", "3", "r"},
                {"3", "4", "2", "1"},
                {"1", "0", "1", "5"}};
        String[][] legalArray = new String[][]{
                {"6", "2", "5", "1"},
                {"1", "2", "3", "0"},
                {"3", "4", "2", "1"},
                {"1", "0", "1", "5"}};

        try {
            ArrayChecker.checkArraySize(ilLegalSizeArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

        try {
            ArrayChecker.checkArraySize(ilLegalValueArray);
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(ArrayChecker.checkArraySize(legalArray));

        try {
            System.out.println(legalArray[4][1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Мы поймали:\n" + e);
        }
    }
}
