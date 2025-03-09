package example.animals;

public abstract class Animal {
    protected String name;
    private static int counter = 0;

    public Animal() {
        counter++;
    }

    public void run(int lengthRun) {
        System.out.println(name + " пробежал " + lengthRun + " метров.");
    }

    public void swim(int lengthSwim) {
        System.out.println(name + " проплыл " + lengthSwim + " метров.");
    }

    public static int getCounter() {
        return counter;
    }
}
