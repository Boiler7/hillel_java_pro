package HW14.Fruits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    @Test
    void addToBoxOne() {
        var res = new Box();
        Orange orange = new Orange();
        res.addToBoxOne(orange);

        assertFalse(res.box.isEmpty());
        assertEquals(orange.getClass(), res.box.get(0).getClass());
    }

    @Test
    void addToBoxMulti() {
        var res = new Box();
        var apple = new Apple();
        res.addToBoxMulti(apple, 5);

        assertEquals(5, res.box.size());
        assertEquals(apple.getClass(), res.box.get(2).getClass());
    }

    @Test
    void getWeight() {
        var res = new Box();
        var apple = new Apple();
        res.addToBoxMulti(apple, 5);

        assertEquals(5.0F, res.getWeight());
    }

    @Test
    void compare() {
        var res = new Box();
        var apple = new Apple();
        res.addToBoxMulti(apple, 5);

        var res1 = new Box();
        var orange = new Orange();
        res1.addToBoxMulti(orange, 5);

        var resc = new Box();
        var applec = new Apple();
        resc.addToBoxMulti(applec, 5);

        assertFalse(res.compare(res1));
        assertTrue(res.compare(resc));
    }

    @Test
    void merge() {
        var res = new Box();
        var apple = new Apple();
        res.addToBoxMulti(apple, 5);

        var resc = new Box();
        var applec = new Apple();
        resc.addToBoxMulti(applec, 5);

        res.merge(resc);

        assertEquals(10, res.box.size());
        assertEquals(0, resc.box.size());
    }
}