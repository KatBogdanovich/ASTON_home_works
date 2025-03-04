package example;

public class Park {
    public Attraction[] attractionsArray;

    public class Attraction {
        private String name;
        private String opening;
        private String closing;
        private int price;

        public Attraction(
                String name,
                String opening,
                String closing,
                int price) {
            this.name = name;
            this.opening = opening;
            this.closing = closing;
            this.price = price;
        }

        public void printAttraction() {
            System.out.println("Название:  " + name);
            System.out.println("Открытие:  " + opening);
            System.out.println("Закрытие:  " + closing);
            System.out.println("Цена билета:  " + price);
        }

    }
}