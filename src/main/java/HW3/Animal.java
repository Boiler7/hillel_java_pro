package HW3;

public abstract class Animal {
    protected String name;
    static private int counter;
    public static int getCounter() {
        return counter;
    }
    public abstract void run(int lenght);
    public abstract void swim(int lenght);
    Animal(String name){
        this.name = name;
    }
}

