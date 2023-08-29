package HW14.Fruits;

public abstract class Fruit {
    private final double weight;

    protected Fruit(double weight){
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
