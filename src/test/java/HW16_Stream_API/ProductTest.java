package HW16_Stream_API;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getProductList() {
        var product = new Product();
        product.addProduct(new Product("Book", 50, false));
        product.addProduct(new Product("Book", 12, false));
        product.addProduct(new Product("Book", 45, false));
        product.addProduct(new Product("Book", 270, false));
        product.addProduct(new Product("Book", 75, false));
        product.addProduct(new Product("Book", 300, false));
        product.addProduct(new Product("Book", 250, false));
        product.addProduct(new Product("Tech", 90, false));
        product.addProduct(new Product("Pack", 70, false));
        product.addProduct(new Product("Toy", 30, false));

        var expectedList = List.of(
                new Product("Book", 270, false),
                new Product("Book", 300, false),
                new Product("Book", 250, false)
        );

        assertEquals(expectedList, product.getProductList());

    }

    @Test
    void getDiscountedBooks() {
        var product = new Product();

        product.addProduct(new Product("Book", 50, false));
        product.addProduct(new Product("Book", 45, false));
        product.addProduct(new Product("Book", 270, false));
        product.addProduct(new Product("Pack", 70, false));
        product.addProduct(new Product("Toy", 30, false));

        var expectedList = List.of(
                new Product("Book", 45, true),
                new Product("Book", 40.5, true),
                new Product("Book", 243.0, true)
        );

        assertEquals(expectedList, product.getDiscountedBooks());
    }

    @Test
    void findCheapestBook() {
        var product = new Product();
        product.addProduct(new Product("Book", 50, false));
        product.addProduct(new Product("Book", 12, false));
        product.addProduct(new Product("Book", 45, false));
        product.addProduct(new Product("Book", 270, false));
        product.addProduct(new Product("Book", 75, false));
        product.addProduct(new Product("Book", 300, false));
        product.addProduct(new Product("Book", 250, false));
        product.addProduct(new Product("Tech", 90, false));
        product.addProduct(new Product("Pack", 70, false));
        product.addProduct(new Product("Toy", 30, false));

        var res = new Product("Book", 12, false);

        assertEquals(res, product.findCheapestBook());
    }

    @Test
    void getThreeLast() {
        var product = new Product();
        product.addProduct(new Product("Book", 50, false));
        product.addProduct(new Product("Book", 12, false));
        product.addProduct(new Product("Book", 45, false));
        product.addProduct(new Product("Book", 270, false));
        product.addProduct(new Product("Book", 75, false));
        product.addProduct(new Product("Book", 300, false));
        product.addProduct(new Product("Book", 250, false));
        product.addProduct(new Product("Tech", 90, false));
        product.addProduct(new Product("Pack", 70, false));
        product.addProduct(new Product("Toy", 30, false));

        var expectedList = List.of(
            new Product("Tech", 90, false),
            new Product("Pack", 70, false),
            new Product("Toy", 30, false)
        );

        assertEquals(expectedList, product.getThreeLast());
    }

    @Test
    void getCalculation() {
        var product = new Product();
        product.addProduct(new Product("Book", 50, false));
        product.addProduct(new Product("Book", 12, false));
        product.addProduct(new Product("Book", 45, false));
        product.addProduct(new Product("Book", 270, false));
        product.addProduct(new Product("Book", 75, false));
        product.addProduct(new Product("Book", 300, false));
        product.addProduct(new Product("Book", 250, false));
        product.addProduct(new Product("Tech", 90, false));
        product.addProduct(new Product("Pack", 70, false));
        product.addProduct(new Product("Toy", 30, false));

        var expectedList = 182;

        assertEquals(expectedList, product.getCalculation());
    }

    @Test
    void getGrouped() {
        var product = new Product();
        product.addProduct(new Product("Book", 50, false));
        product.addProduct(new Product("Book", 12, false));
        product.addProduct(new Product("Book", 45, false));
        product.addProduct(new Product("Tech", 90, false));
        product.addProduct(new Product("Pack", 70, false));
        product.addProduct(new Product("Toy", 30, false));

        var expectedMap = Map.of(
                "Book", List.of(
                        new Product("Book", 50, false),
                        new Product("Book", 12, false),
                        new Product("Book", 45, false)
                ),
                "Tech", List.of(
                        new Product("Tech", 90, false)
                ),
                "Pack", List.of(
                        new Product("Pack", 70, false)
                ),
                "Toy", List.of(new Product("Toy", 30, false)
                )
        );

        assertEquals(expectedMap, product.getGrouped());
    }
}