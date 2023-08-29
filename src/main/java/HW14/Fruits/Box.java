package HW14.Fruits;

import java.util.Collection;
import java.util.LinkedList;

public class Box<T extends Fruit>{
    LinkedList<Fruit> box = new LinkedList<>();

    public void addToBoxOne(Fruit fruit) {
        if(box.isEmpty()){
            box.add(fruit);
        }
        if(fruit instanceof Apple && box.get(0) instanceof Apple){
            box.add(fruit);
        } else if(fruit instanceof Orange && box.get(0) instanceof Orange){
            box.add(fruit);
        }else {
            return;
        }
    }

    public void addToBoxMulti(Fruit fruit, int amount) {
        for(int i = 0; i < amount; i++){
            box.add(fruit);
        }
    }

    public double getWeight(){
        var weight = 0.0;
        for(var element: box){
            weight += element.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<T> toCompare){
        return getWeight() == toCompare.getWeight();
    }

    public void merge(Box<T> toMerge) {
        if(this.box.isEmpty() || toMerge.box.isEmpty()){
            toMerge.box.addAll((Collection<T>) toMerge);
        }
        if ((toMerge.box.get(0).getClass() == box.get(0).getClass()) || getWeight() == 0) {
            box.addAll(toMerge.box);
            toMerge.box.clear();
        } else {
            return;
        }
    }
}