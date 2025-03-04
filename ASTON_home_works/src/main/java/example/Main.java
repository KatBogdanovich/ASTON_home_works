package example;

public class Main {

    public static void main(String[] args) {

        //Задание 10.2 Товар
        System.out.println("Массив товаров категории <Книги>");
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product(
                "Шарф для ангела",
                "12.2023",
                "ИД Антология",
                "Россия",
                13,
                true);
        productsArray[1] = new Product(
                "Когда в доме живут феи",
                "01.2023",
                "ИД АМОЗА.Дети",
                "Россия",
                21,
                true);
        productsArray[2] = new Product(
                "Чижик-Пыжик и хранители Петербурга",
                "01.2024",
                "ИД Антология",
                "Россия",
                35,
                false);
        productsArray[3] = new Product(
                "Все про Дедморозовку",
                "06.2021",
                "Росмэн",
                "Россия",
                34,
                false);
        productsArray[4] = new Product(
                "Ужасный Генри",
                "08.2022",
                "Издательство Мелик-Пашаев",
                "Россия",
                17,
                false);
        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].printProductInfo();
            System.out.println();
        }

        //Задание 10.3 Парк

        System.out.println("Задание Парк");
        Park park1 = new Park();
        park1.attractionsArray = new Park.Attraction[3];
        park1.attractionsArray[0] = new Park().new Attraction(
                "Вальс",
                "8:00",
                "20:00",
                5);
        park1.attractionsArray[1] = new Park().new Attraction(
                "Тарелка",
                "9:00",
                "20:00",
                7);
        park1.attractionsArray[2] = new Park().new Attraction(
                "Колесо обозрения",
                "8:00",
                "20:00",
                6);

        park1.attractionsArray[1].printAttraction();
    }
}
