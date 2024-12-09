package by.aston.animal;

public abstract class Animal {

    protected String name;
    private static int count;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public static int getCountAnimals() {
        return count;
    }

    abstract public void run(int distance);

    public void swim(int distance) {
        System.out.println("Я " + name + " не плаваю.");
    }
}
