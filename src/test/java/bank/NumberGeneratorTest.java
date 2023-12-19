package bank;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {
    @Test
    void shouldGeneratePAN() {
        var result = NumberGenerator.generatePAN();
                assertEquals(16, result.length());
    }

    @Test
    void shouldGeneratePIN() {
        var result = NumberGenerator.generatePIN();
                assertEquals(4, result.length());
    }

    @Test
    void shouldGenerateCVV() {
        var result = NumberGenerator.generateCVV();
        assertEquals(3, result.length());
    }
    @Test
    void shouldGetShortExpirationDate() throws ParseException {
        var date = new SimpleDateFormat("dd/MM/yyyy").parse("17/12/2023");
        var result = NumberGenerator.getShortExpirationDate(date);

        assertNotNull(result);
        assertEquals("12/23", result);
    }


}