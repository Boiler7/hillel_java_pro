package HW14.Fruits;

import java.util.LinkedList;

public class Box<T extends Fruit>{
    LinkedList<T> box = new LinkedList<>();
    private float weightOfBox;


    public void addToBoxOne(T fruit) {
        if((fruit instanceof Apple && box.get(1) instanceof Apple || box.isEmpty())){
            box.add(fruit);
        } else if ((fruit instanceof Orange && box.get(1) instanceof Orange) || box.isEmpty()) {
            box.add(fruit);
        }
        else {
            return;
        }
    }
    public void addToBoxMulti(T fruit, int amount) {
        for(int i = 0; i < amount; i++){
            box.add(fruit);
        }
    }

    public float getWeight(){
        int sizeOfBox = box.size();
        if(box.get(1) instanceof Apple){
            return this.weightOfBox = sizeOfBox * 1.0F;
        }
        else {
            return weightOfBox = sizeOfBox * 1.5F;
        }
    }
    public boolean compare(Box boxToCompare){
        if(this.getWeight() == boxToCompare.getWeight()){
            return true;
        }
        else {
            return false;
        }
    }
    public void merge(Box boxToMerge) {
        if (boxToMerge.box.get(0).getClass() == this.box.get(0).getClass() || this.getWeight() == 0.0F) {
            this.box.addAll(boxToMerge.box);
            boxToMerge.box.clear();
        } else {
            return;
        }
    }
}