package HW8.phonebook;

import HW8_Lists.phonebook.PhoneBook;
import HW8_Lists.phonebook.Record;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @Test
    void addAndFind() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Nicole", "0671245999");
        phoneBook.add("Anna", "0671245999");
        phoneBook.add("Carter", "0671245999");
        phoneBook.add("Kyrylo", "0671245999");

        Record record = phoneBook.find("Kyrylo");

        assertNotNull(record);
        assertEquals("Kyrylo", record.getName());
        assertEquals("0671245999", record.getNumber());
    }

    @Test
    void findAll() {
        var phoneBook = new PhoneBook();
        phoneBook.add("Kyrylo", "0698548599");
        phoneBook.add("Nicole", "0675455999");
        phoneBook.add("Anna", "0677949549");
        phoneBook.add("Carter", "0671964999");
        phoneBook.add("Kyrylo", "0671245999");

        List<Record> foundRecords = phoneBook.findAll("Kyrylo");

        assertEquals(2, foundRecords.size());

    }
}