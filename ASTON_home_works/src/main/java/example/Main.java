package example;

import example.animals.Animal;
import example.animals.Bowl;
import example.animals.Cat;
import example.animals.Dog;
import example.geometry.Circle;
import example.geometry.Rectangle;
import example.geometry.Triangle;

public class Main {

    public static void main(String[] args) {

        // Задание 1.

        Dog dog1 = new Dog("Рэкс");
        dog1.run(505);
        dog1.swim(5);

        Cat cat1 = new Cat("Барсик", 3);
        cat1.run(20);
        cat1.swim(35);

        Bowl bowl = new Bowl();

        System.out.println("Количество еды в миске: " + bowl.getFoodVolume());
        bowl.addFood(12);
        System.out.println("Количество еды в миске: " + bowl.getFoodVolume());
        bowl.feedCat(cat1);
        System.out.println("Осталось еды в миске: " + bowl.getFoodVolume());

        Cat[] cats = new Cat[]{
                cat1,
                new Cat("Мурзик", 2),
                new Cat("Пират", 4),
                new Cat("Валет", 1)};
        for (Cat cat : cats) {
            bowl.feedCat(cat);
        }

        System.out.println("Создано котов: " + Cat.getCounter());
        System.out.println("Создано собак: " + Dog.getCounter());
        System.out.println("Всего животных: " + Animal.getCounter());
        System.out.println();

        // Задание 2.

        Triangle triangle = new Triangle(1, 3, 6, 5, "красный", "голубой");
        Triangle triangle1 = new Triangle(3, 5, 7, 3, "розовый", "зеленый");
        triangle.printInfo();
        triangle1.printInfo();

        Circle circle = new Circle(4, "бирюзовый", "синий");
        Circle circle1 = new Circle(2, "фиолетовый", "черный");
        circle.printInfo();
        circle1.printInfo();

        Rectangle rectangle = new Rectangle(3, 6, "белый", "черный");
        Rectangle rectangle1 = new Rectangle(4, 8, "серый", "оранжевый");
        rectangle.printInfo();
        rectangle1.printInfo();
    }
}

