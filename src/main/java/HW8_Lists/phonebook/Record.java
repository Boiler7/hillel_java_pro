package HW8_Lists.phonebook;

import java.util.Objects;

public class Record {
    private String name;
    private String number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(name, record.name) && Objects.equals(number, record.number);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    public String getNumber() {
        return number;
    }

    public Record(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
