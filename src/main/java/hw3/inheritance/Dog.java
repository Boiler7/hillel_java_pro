package hw3.inheritance;

import lombok.Getter;

public class Dog extends Animal{
    @Getter
    static private int counter;

    public void run(int lenght){
        if (lenght > 500)
            lenght = 500;

        System.out.println(name + " пробіг " + lenght + " м.");
    }
    public void swim(int lenght){
        if (lenght > 10)
            lenght = 10;

        System.out.println(name + " проплив " + lenght + " м.");
    }
    public Dog(String name){
        super(name);
        counter+=1;
    }
}
