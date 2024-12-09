package by.aston.animal;

public class Dog extends Animal {

    public static final int RUNNING_DISTANCE = 500;
    public static final int SWIMMING_DISTANCE = 10;

    private static int count = 0;

    public Dog(String name) {
        super(name);
        count++;
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

    @Override
    public void swim(int distance) {
        if (distance <= SWIMMING_DISTANCE) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не проплывет " + distance + " м.");
        }
    }
}
