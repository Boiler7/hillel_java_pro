public abstract class Animal {
    private String name;
    public void run(int lenght){
        System.out.println(name + " пробіг " + lenght + " м.");
    }
    public void swim(int lenght){
        System.out.println(name + " проплив " + lenght + " м.");
    }
}
