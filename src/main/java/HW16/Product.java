package HW16;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Product {
    private String category;
    private double price;
    private boolean isWithDiscount;
    private LocalDate date;

    public Product(){};
    public Product(String category, double price, boolean isWithDiscount) {
        this.category = category;
        this.price = price;
        this.isWithDiscount = isWithDiscount;
        this.date = LocalDate.now();
    }
    private final List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }
    public List<Product> getProductList(){
        return productList.stream()
                .filter(product -> product.price >= 250)
                .filter(product -> product.category.equalsIgnoreCase("Book"))
                .toList();
    }

    public List<Product> getListOfBooksWith10discount(){
        return productList.stream()
                .filter(product -> product.category.equalsIgnoreCase("Book"))
                .map(product -> {
                            double priceWithDiscount = product.price - 0.1 * product.price;
                            return new Product(category, priceWithDiscount, true);
                })
                .toList();
    }



    public Product findCheapestBook() {
        return productList.stream()
                .filter(product -> product.category.equalsIgnoreCase("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("No cheapest book found"));
    }

    public List<Product> getThreeLast(){
        return productList.stream()
                .skip(productList.size() - 3)
                .collect(Collectors.toList());
    }

    public double getCalculation(){
        LocalDate currentDate = LocalDate.now();
        return productList.stream()
                .filter(product -> product.getDate().getYear() == currentDate.getYear())
                .filter(product -> product.category.equals("Book"))
                .filter(product -> product.price <= 75.00)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Map<String, List<Product>> getGrouped(){
        return productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && isWithDiscount == product.isWithDiscount && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, price, isWithDiscount);
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

}
