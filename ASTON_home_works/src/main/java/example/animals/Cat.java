package example.animals;

public class Cat extends Animal {
    private static int counter = 0;
    private boolean catIsFull = false;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        counter++;
    }

    @Override
    public void run(int lengthRun) {
        if (lengthRun <= 200)
            super.run(lengthRun);
        else
            System.out.println(name + " не может пробежать больше 200 метров.");
    }

    @Override
    public void swim(int lengthSwim) {
        System.out.println(name + " не умеет плавать.");
    }

    public static int getCounter() {
        return counter;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

    public void eat(int volume) {
        if (volume == appetite) {
            catIsFull = true;
            System.out.println(name + " съел " + volume + " порций еды. Кот сыт.");
        } else
            System.out.println("Кот остался голодным.");
    }
}
