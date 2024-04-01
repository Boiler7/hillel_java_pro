package HW8;

import hw8.lists.ListFunction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListFunctionTest {


    @Test
    void countOccurence() {
        List<String> items = new ArrayList<>();
        items.add("apple");
        items.add("oracle");
        items.add("pine");
        items.add("pen");
        items.add("forest");
        items.add("ore");
        items.add("garden");
        items.add("house");
        items.add("core");
        items.add("forest");
        items.add("garden");
        items.add("pen");
        items.add("oracle");
        items.add("ore");
        items.add("apple");
        items.add("apple");

        assertEquals(3, ListFunction.countOccurrence(items, "apple"));
    }

    @Test
    void toList() {
        int[] array = {1, 2, 3};
        List<Integer> result = List.of(1,2,3);

        assertEquals(result, ListFunction.toList(array));
    }

    @Test
    void findUnique() {
        List<String> result = List.of("1","2","3");
        List<String> funct = List.of("1","2","3","1","3","2","1");


        assertEquals(ListFunction.findUnique(funct), result);

    }

    @Test
    void findOccurency(){
        List<String> items = List.of("apple", "pine", "olive", "apple", "pine");
        List<ListFunction.Myresult> result = ListFunction.findOccurrence(items);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(2, result.get(0).occurance());
        assertEquals("apple", result.get(0).name());

    }
}
