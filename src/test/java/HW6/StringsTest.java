package HW6;

import HW6_Symbols_and_tests.Strings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    @Test
    void getOccurrence(){
        var strings = new Strings();
        int result = strings.findSymbolOccurrence("Lorem ipsum dolor ips sit amet, conseipsctetur ips adipiscing elit. Proin ac", "ips");
        assertEquals(4, result);
    }

    @Test
    void getIndex(){
        var strings = new Strings();
        int result = strings.findWordPosition("hhhloremoio", "lorem");
        assertEquals(3, result);
    }
    @Test
    void getReversedString(){
        var strings = new Strings();
        String result = strings.stringReverse("irem");
        assertEquals("meri", result);
    }
@Test
    void checkIsPalindrome(){
        var strings = new Strings();
        boolean result = strings.isPolindrome("uttu");
        assertTrue(result);
    }

}