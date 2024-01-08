package HW16_Stream_API;

import lombok.Getter;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Product {
    @Getter
    private String category;
    @Getter
    private double price;
    private boolean isWithDiscount;
    @Getter
    private LocalDate date;

    public Product(){}
    public Product(String category, double price, boolean isWithDiscount, LocalDate date) {
        this.category = category;
        this.price = price;
        this.isWithDiscount = isWithDiscount;
        this.date = date;
    }


    public List<Product> getProductList(List<Product> productList){
        return productList.stream()
                .filter(product -> product.price >= 250)
                .filter(product -> product.category.equalsIgnoreCase("Book"))
                .toList();
    }

    public List<Product> getDiscountedBooks(List<Product> productList){
        return productList.stream()
                .filter(product -> product.category.equalsIgnoreCase("Book"))
                .map(product -> new Product(product.category, product.price * 0.9, true, LocalDate.now()))
                .collect(Collectors.toList());
    }

    public Product findCheapestBook(List<Product> productList) {
        return productList.stream()
                .filter(product -> product.category.equalsIgnoreCase("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("No cheapest book found"));
    }

    public List<Product> getThreeLast(List<Product> productList){
        return productList.stream()
                .sorted(Comparator.comparing(Product::getDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public double getCalculation(List<Product> productList){
        LocalDate currentDate = LocalDate.now();
        return productList.stream()
                .filter(product -> product.getDate().getYear() == currentDate.getYear())
                .filter(product -> product.category.equals("Book"))
                .filter(product -> product.price <= 75.00)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Map<String, List<Product>> getGrouped(List<Product> productList){
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
}
