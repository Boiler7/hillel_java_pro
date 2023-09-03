package HW14.Fruits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    @Test
    void add() {
        var res = new Box();
        Orange orange = new Orange();
        res.add(orange);

        assertFalse(res.box.isEmpty());
    }

    @Test
    void addMulti() {
        var res = new Box();
        var apple = new Apple();
        res.addMulti(apple, 5);

        assertEquals(5, res.box.size());
    }

    @Test
    void getWeight() {
        var res = new Box();
        var apple = new Apple();
        res.addMulti(apple, 5);

        assertEquals(5.0F, res.getWeight());
    }

    @Test
    void compare() {
        var res = new Box();
        var apple = new Apple();
        res.addMulti(apple, 5);

        var res1 = new Box();
        var orange = new Orange();
        res1.addMulti(orange, 2);

        var resc = new Box();
        var applec = new Apple();
        resc.addMulti(applec, 3);

        assertFalse(res.compare(res1));
        assertTrue(res1.compare(resc));
    }

    @Test
    void merge() {
        var res = new Box();
        var apple = new Apple();
        res.addMulti(apple, 5);

        var resc = new Box();
        var applec = new Apple();
        resc.addMulti(applec, 5);

        res.merge(resc);

        assertEquals(10, res.box.size());
        assertEquals(0, resc.box.size());
    }
}