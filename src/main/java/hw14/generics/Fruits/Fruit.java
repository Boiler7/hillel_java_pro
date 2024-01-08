package hw14.generics.Fruits;

import lombok.Getter;

@Getter
public abstract class Fruit {
    private final double weight;

    protected Fruit(double weight){
        this.weight = weight;
    }

}
