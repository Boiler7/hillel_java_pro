package HW3;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсік");
        Dog dog1 = new Dog("Бобік");

        cat1.run(150);
        cat2.run(250);
        cat1.swim(5);
        dog1.run(400);
        dog1.swim(15);

        System.out.println("Створено котів: " + Cat.getCounter());
        System.out.println("Створено собак: " + Dog.getCounter());
    }
}