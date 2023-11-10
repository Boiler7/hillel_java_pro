package HW8_Lists;

import java.util.ArrayList;
import java.util.List;

public class ListFunction {
    public static void main(String[] args) {
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


        calcOccurrence(items);

    }

    public static int countOccurrence(List<String> list, String string) {
        int occurence = 0;
        for (var elements : list) {
            if (elements.equals(string)) {
                occurence++;
            }
        }
        return occurence;
    }

    public static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int a : array) {
            list.add(a);
        }
        return list;
    }

    public static List<String> findUnique(List<String> list) {
        List<String> uniqueNumbers = new ArrayList<>();
        for (var elements : list) {
            if (!uniqueNumbers.contains(elements)) {
                uniqueNumbers.add(elements);
            }
        }
        return uniqueNumbers;
    }

    public record Myresult(String name, int occurance) {
    }

    public static void calcOccurrence(List<String> list) {
        var result = new ArrayList<>(findUnique(list));

        for (var res : result) {
            System.out.println(res + ": " + countOccurrence(list, res));
        }
    }

    public static List<Myresult> findOccurrence(List<String> list) {
        List<Myresult> result = new ArrayList<>();

        for (String item : list) {
            boolean isFound = false;

            for (Myresult res : result) {
                if (res.name().equals(item)) {
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                int occurrence = countOccurrence(list, item);
                result.add(new Myresult(item, occurrence));
            }
        }

        return result;
    }
}
