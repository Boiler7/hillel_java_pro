package hw16.stream.api;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {


    @Test
    void getProductList() {
        var product = new Product();

        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Book", 50, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 12, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 45, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 270, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 75, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 300, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 250, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Tech", 90, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Pack", 70, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Toy", 30, false, LocalDate.of(2023, 5, 25)));

        var expectedList = List.of(
                new Product("Book", 270, false, LocalDate.of(2023, 5, 25)),
                new Product("Book", 300, false, LocalDate.of(2023, 5, 25)),
                new Product("Book", 250, false, LocalDate.of(2023, 5, 25))
        );

        assertEquals(expectedList, product.getProductList(productList));

    }

    @Test
    void getDiscountedBooks() {
        var product = new Product();

        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Book", 50, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 45, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 270, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Pack", 70, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Toy", 30, false , LocalDate.of(2023, 5, 25)));

        var expectedList = List.of(
                new Product("Book", 45, true, LocalDate.of(2023, 5, 25)),
                new Product("Book", 40.5, true, LocalDate.of(2023, 5, 25)),
                new Product("Book", 243.0, true, LocalDate.of(2023, 5, 25))
        );

        assertEquals(expectedList, product.getDiscountedBooks(productList));
    }

    @Test
    void findCheapestBook() {
        var product = new Product();

        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Book", 50, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 12, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 45, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 270, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 75, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 300, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 250, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Tech", 90, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Pack", 70, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Toy", 30, false, LocalDate.of(2023, 5, 25)));

        var res = new Product("Book", 12, false, LocalDate.of(2023, 5, 25));

        assertEquals(res, product.findCheapestBook(productList));
    }

    @Test
    void getThreeLast() {
        var product = new Product();

        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Book", 50, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 12, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 45, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 270, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 75, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 300, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 250, false, LocalDate.of(2023, 8, 25)));
        productList.add(new Product("Tech", 90, false, LocalDate.of(2023, 7, 25)));
        productList.add(new Product("Pack", 70, false, LocalDate.of(2023, 6, 25)));
        productList.add(new Product("Toy", 30, false, LocalDate.of(2023, 5, 25)));

        var expectedList = List.of(
                new Product("Book", 250, false, LocalDate.of(2023, 8, 25)),
                new Product("Tech", 90, false, LocalDate.of(2023, 6, 25)),
                new Product("Pack", 70, false, LocalDate.of(2023, 7, 25))
        );

        assertEquals(expectedList, product.getThreeLast(productList));
    }

    @Test
    void getCalculation() {
        var product = new Product();

        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Book", 50, false, LocalDate.now()));
        productList.add(new Product("Book", 12, false, LocalDate.now()));
        productList.add(new Product("Book", 45, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 270, false, LocalDate.now()));
        productList.add(new Product("Book", 75, false, LocalDate.now()));
        productList.add(new Product("Book", 300, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 250, false, LocalDate.now()));
        productList.add(new Product("Tech", 90, false, LocalDate.now()));
        productList.add(new Product("Pack", 70, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Toy", 30, false, LocalDate.of(2023, 5, 25)));

        var expectedList = 137;

        assertEquals(expectedList, product.getCalculation(productList));
    }

    @Test
    void getGrouped() {
        var product = new Product();

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Book", 50, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 12, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Book", 45, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Tech", 90, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Pack", 70, false, LocalDate.of(2023, 5, 25)));
        productList.add(new Product("Toy", 30, false, LocalDate.of(2023, 5, 25)));

        var expectedMap = Map.of(
                "Book", List.of(
                        new Product("Book", 50, false, LocalDate.of(2023, 5, 25)),
                        new Product("Book", 12, false, LocalDate.of(2023, 5, 25)),
                        new Product("Book", 45, false, LocalDate.of(2023, 5, 25))
                ),
                "Tech", List.of(
                        new Product("Tech", 90, false, LocalDate.of(2023, 5, 25))
                ),
                "Pack", List.of(
                        new Product("Pack", 70, false, LocalDate.of(2023, 5, 25))
                ),
                "Toy", List.of(new Product("Toy", 30, false, LocalDate.of(2023, 5, 25))
                )
        );

        assertEquals(expectedMap, product.getGrouped(productList));
    }
}