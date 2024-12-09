package by.aston.animal;

public class Cat extends Animal {

    public static final int RUNNING_DISTANCE = 200;
    private static int count = 0;
    private boolean isFull = false;
    private int sizeStomach;

    public Cat(String name, int sizeStomach) {
        super(name);
        count++;
        this.sizeStomach = sizeStomach;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(int distance) {
        if (distance <= RUNNING_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не пробежит " + distance + " м.");
        }
    }

    public void eat(Bowl bowl) {
        if (bowl.getAmount() >= sizeStomach) {
            bowl.getFood(sizeStomach);
            isFull = true;
            System.out.println(name + " сыт.");
        } else {
            System.out.println(name + " голоден.");
        }
    }

    public void setFull() {
        isFull = false;
    }
}
