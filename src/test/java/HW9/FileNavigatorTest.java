package HW9;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileNavigatorTest {

    @Test
    void add() {
        var navigator = new FileNavigator();
        navigator.add("path/afiles", "ahome", 36);
        List<FileData> files = navigator.find("path/afiles");
        assertEquals("ahome", files.get(0).getNameOfFile());
    }


    @Test
    void find() {
        var navigator = new FileNavigator();
        navigator.add("path/afiles", "ahome", 36);
        navigator.add("path/bfiles", "bhome", 456);
        navigator.add("path/cfiles", "chome", 56);

        List<FileData> files = navigator.find("path/afiles");

        assertEquals("ahome", files.get(0).getNameOfFile());
    }

    @Test
    void filterBySize() {
        var navigator = new FileNavigator();
        navigator.add("path/afiles", "ahome", 36);
        navigator.add("path/bfiles", "bhome", 456);
        navigator.add("path/cfiles", "chome", 56);

        List<FileData> filteredFiles = navigator.filterBySize(10);
        assertTrue(filteredFiles.isEmpty());
    }

    @Test
    void remove() {
        var navigator = new FileNavigator();
        navigator.add("path/afiles", "ahome", 36);
        navigator.add("path/bfiles", "bhome", 456);
        navigator.add("path/cfiles", "chome", 56);

        navigator.remove("path/cfiles");

        List<FileData> result = navigator.find("path/cfiles");
        assertNull(result);
    }

    @Test
    void sortBySize() {
        var navigator = new FileNavigator();
        navigator.add("path/afiles", "ahome", 36);
        navigator.add("path/bfiles", "bhome", 456);
        navigator.add("path/cfiles", "chome", 56);

        List<FileData> result = List.of(
                new FileData("path/afiles", "ahome", 36),
                new FileData("path/cfiles", "chome", 56),
                new FileData("path/bfiles", "bhome", 456)
        );

        List<FileData> actualResult = navigator.sortBySize();

        assertEquals(result, actualResult);
    }
}