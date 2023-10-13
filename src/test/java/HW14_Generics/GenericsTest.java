package HW14_Generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericsTest {

    @Test
    void toList(){
        var result = new Generics();

        Integer[] array ={1, 2, 3};
        assertNotNull(result.toList(array));
        assertTrue(result.toList(array).contains(1));
    }
}