package hw3.inheritance;

import lombok.Getter;

public abstract class Animal {
    protected String name;
    @Getter
    static private int counter;

    public abstract void run(int lenght);
    public abstract void swim(int lenght);
    Animal(String name){
        this.name = name;
    }
}
