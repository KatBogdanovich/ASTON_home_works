package example.animals;

public class Dog extends Animal {
    private static int counter = 0;

    public Dog(String name) {
        this.name = name;
        counter++;
    }

    @Override
    public void run(int lengthRun) {
        if (lengthRun <= 500)
            super.run(lengthRun);
        else
            System.out.println(name + " не может пробежать больше 500 метров.");
    }

    @Override
    public void swim(int lengthSwim) {
        if (lengthSwim <= 10)
            super.swim(lengthSwim);
        else
            System.out.println(name + " не может проплыть больше 10 метров.");
    }

    public static int getCounter() {
        return counter;
    }
}
