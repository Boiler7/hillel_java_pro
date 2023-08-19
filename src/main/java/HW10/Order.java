package HW10;

public class Order {

    private long numberOfOrder;
    private final String nameOfCustomer;

    public void setNumberOfOrder(long numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public long getNumberOfOrder() {
        return numberOfOrder;
    }

    public Order(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }
}
