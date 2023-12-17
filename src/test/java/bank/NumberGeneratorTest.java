package bank;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    @Test
    void shouldGenerateExpirationDate() {
//        LocalDate date = LocalDate.of(2023, 12, 17);
//        var result = NumberGenerator.generateExpirationDate(date);
//
//        assertNotNull(result);
//        assertTrue(result.after(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant())));
    }

    @Test
    void shouldGetShortExpirationDate() throws ParseException {
        var date = new SimpleDateFormat("dd/MM/yyyy").parse("17/12/2023");
        var result = NumberGenerator.getShortExpirationDate(date);

        assertNotNull(result);
        assertEquals("12/23", result);
    }
}