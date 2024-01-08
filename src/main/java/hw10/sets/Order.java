package hw10.sets;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {

    private long numberOfOrder;
    private final String nameOfCustomer;

    public Order(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }
}
