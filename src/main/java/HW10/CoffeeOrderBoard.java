package HW10;

import java.util.HashSet;
import java.util.Iterator;

public class CoffeeOrderBoard {
     static final HashSet<Order> set1 = new HashSet<Order>();
    public void add( String name){
        set1.add(new Order(name));
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
