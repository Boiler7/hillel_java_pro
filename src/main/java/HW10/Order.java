package HW10;

public class Order {
    private static long nextNumberOfOrder;

    private final long numberOfOrder;
    private final String nameOfCustomer;
        public long getNumberOfOrder() {
        return numberOfOrder;
    }

    public Order(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
        this.numberOfOrder = nextNumberOfOrder++;
    }
}
