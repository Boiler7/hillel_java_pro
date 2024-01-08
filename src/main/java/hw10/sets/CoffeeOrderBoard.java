package hw10.sets;

import java.util.HashSet;
import java.util.Iterator;

public class CoffeeOrderBoard {
    HashSet<Order> set1 = new HashSet<>();
    public void add( String name){
        Order order = new Order(name);
        set1.add(order);
        order.setNumberOfOrder(set1.size());

    }
    public void deliver(){
        Iterator<Order> iterator = set1.iterator();
        if(iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
    }
    public void deliver(int number){
        Iterator<Order> iterator = set1.iterator();
        while(iterator.hasNext()){
            Order order = iterator.next();
            if(order.getNumberOfOrder() == number){
                iterator.remove();
                break;
            }
        }
    }
}
