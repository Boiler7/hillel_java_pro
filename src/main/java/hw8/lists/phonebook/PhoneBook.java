package hw8.lists.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private final List<Record> records;

    public PhoneBook() {
        records = new ArrayList<>();
    }
    public void add(String name, String number){
            records.add(new Record(name, number));
    }

    public Record find(String name) {
        for (Record record : records) {
            if (record.getName().equals(name)) {
                return record;
            }
        }
        return null;
    }
    public List<Record> findAll(String name){
        List<Record> res = new ArrayList<>();
        for(var element : records) {
            if (element.getName().equals(name)) {
                res.add(element);
            }
        }
        return res;
    }
}
