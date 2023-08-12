package HW9;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileNavigatorTest {

    @Test
    void add() {
        var navigator = new FileNavigator();
        var fileData = new FileData("path/afiles", "ahome", 36);
        navigator.add("path/afiles", fileData);

        List<FileData> files = navigator.find("path/afiles");

        List<FileData> result = List.of(
                new FileData("path/afiles", "ahome", 36)
        );

        assertEquals(result, files);
    }

    @Test
    void addWithError() {
        var navigator = new FileNavigator();
        var fileData = new FileData("path/bfiles", "ahome", 36);

        var result = navigator.add("path/afiles", fileData);
        List<FileData> files = navigator.find("path/afiles");

        assertNull(files);
        assertEquals("Error: Inconsistent path", result);
    }


    @Test
    void find() {
        var navigator = new FileNavigator();

        var fileData = new FileData("path/afiles", "ahome", 36);
        navigator.add("path/afiles", fileData);

        List<FileData> files = navigator.find("path/afiles");

        assertEquals("ahome", files.get(0).getNameOfFile());
    }


    @Test
    void filterBySize() {
        var navigator = new FileNavigator();
        var fileData = new FileData("path/afiles", "ahome", 36);
        navigator.add("path/afiles", fileData);

        var fileData1 = new FileData("path/bfiles", "bhome", 456);
        navigator.add("path/bfiles", fileData1);

        var fileData2 = new FileData("path/cfiles", "chome", 56);
        navigator.add("path/cfiles", fileData);

        navigator.add("path/bfiles", fileData1);
        navigator.add("path/cfiles", fileData2);

        List<FileData> filteredFiles = navigator.filterBySize(10);
        assertTrue(filteredFiles.isEmpty());
    }

    @Test
    void remove() {
        var navigator = new FileNavigator();
        var fileData = new FileData("path/afiles", "ahome", 36);
        navigator.add("path/afiles", fileData);

        var fileData1 = new FileData("path/bfiles", "bhome", 456);
        navigator.add("path/bfiles", fileData1);

        var fileData2 = new FileData("path/cfiles", "chome", 56);
        navigator.add("path/cfiles", fileData2);

        navigator.remove("path/cfiles");

        List<FileData> result = navigator.find("path/cfiles");
        assertNull(result);
    }

    @Test
    void sortBySize() {
        var navigator = new FileNavigator();
        var fileData = new FileData("path/afiles", "ahome", 36);
        navigator.add("path/afiles", fileData);

        var fileData1 = new FileData("path/bfiles", "bhome", 456);
        navigator.add("path/bfiles", fileData1);

        var fileData2 = new FileData("path/cfiles", "chome", 56);
        navigator.add("path/cfiles", fileData2);


        List<FileData> result = List.of(
                new FileData("path/afiles", "ahome", 36),
                new FileData("path/cfiles", "chome", 56),
                new FileData("path/bfiles", "bhome", 456)
        );

        List<FileData> actualResult = navigator.sortBySize();

        assertEquals(result, actualResult);
    }
}