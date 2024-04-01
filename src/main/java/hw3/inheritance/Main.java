package hw3.inheritance;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Murzik");
        Cat cat2 = new Cat("Barsik");
        Dog dog1 = new Dog("Bobik");

        cat1.run(150);
        cat2.run(250);
        cat1.swim(5);
        dog1.run(400);
        dog1.swim(15);

        System.out.println("Cats created: " + Cat.getCounter());
        System.out.println("Dogs created: " + Dog.getCounter());
    }
}
