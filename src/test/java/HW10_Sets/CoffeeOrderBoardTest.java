package HW10_Sets;

import HW10_Sets.CoffeeOrderBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeOrderBoardTest {

    @Test
    void add() {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Kyrylo");
        coffeeOrderBoard.add("Nicole");
        coffeeOrderBoard.add("Violet");

        assertEquals(3, coffeeOrderBoard.set1.size());
    }

    @Test
    void deliver() {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Kyrylo");
        coffeeOrderBoard.add("Nicole");
        coffeeOrderBoard.add("Violet");

        coffeeOrderBoard.deliver();

        assertEquals(2, coffeeOrderBoard.set1.size());
    }

    @Test
    void deliverWithNumber() {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Kyrylo");
        coffeeOrderBoard.add("Nicole");
        coffeeOrderBoard.add("Violet");

        coffeeOrderBoard.deliver(2);

        assertEquals(2, coffeeOrderBoard.set1.size());
    }
}