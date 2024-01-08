package hw8.lists.phonebook;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Record {
    private final String name;
    private final String number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(name, record.name) && Objects.equals(number, record.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    public Record(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
