package by.aston;

import by.aston.animal.Animal;
import by.aston.animal.Bowl;
import by.aston.animal.Cat;
import by.aston.animal.Dog;
import by.aston.figure.Circle;
import by.aston.figure.Figure;
import by.aston.figure.Rectangle;
import by.aston.figure.Triangle;

public class Main {
    public static void main(String[] args) {

        Animal cat1 = new Cat("cat1", 3);
        Animal cat2 = new Cat("cat2", 5);
        Animal cat3 = new Cat("cat3", 4);
        Animal dog1 = new Dog("Dog1");

        cat1.run(10);
        cat1.run(1000);
        cat2.swim(10);

        dog1.run(150);
        dog1.run(1500);
        dog1.swim(5);
        dog1.swim(200);

        System.out.println("Количество котов " + Cat.getCount());
        System.out.println("Количество собак " + Dog.getCount());
        System.out.println("Количество животных " + Animal.getCountAnimals());

        Bowl bowl = new Bowl(10, 5);
        ((Cat) cat1).eat(bowl);
        bowl.addFood(1);
        ((Cat) cat2).eat(bowl);
        bowl.addFood(10);
        ((Cat) cat3).eat(bowl);


        Figure[] figures = {new Circle(10.0, "black", "green"), new Rectangle(5, 10, "green", "black"), new Triangle(3, 8, 5, 5, "red", "blue")};
        for (Figure figure : figures) {
            System.out.println(figure.calculatePerimeter());
            System.out.println(figure.calculateSquare());
        }
    }
}