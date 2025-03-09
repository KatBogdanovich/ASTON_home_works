package example.animals;

public class Bowl {
    private int foodVolume;

    public void addFood(int volume) {
        foodVolume += volume;
    }

    public void feedCat(Cat cat) {
        if (foodVolume >= cat.getAppetite()) {
            foodVolume -= cat.getAppetite();
            System.out.println("Еды достаточно.");
            cat.eat(cat.getAppetite());
            System.out.println();
        } else {
            System.out.println(cat.getName() + " - не хватило еды!!!");
            System.out.println();
        }
    }

    public int getFoodVolume() {
        return foodVolume;
    }
}
