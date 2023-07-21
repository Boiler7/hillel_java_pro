package HW3;

public class Cat extends Animal{
    static private int catCounter;
    public static int getCounter() {
        return catCounter;
    }
    public void run(int lenght){
        if (lenght > 200)
            lenght = 200;

        System.out.println(name + " пробіг " + lenght + " м.");
    }
    public void swim(int lenght){
        System.out.println(name + " не вміє плавати ");
    }
    public Cat(String name){
        super(name);
        catCounter+=1;
    }
}