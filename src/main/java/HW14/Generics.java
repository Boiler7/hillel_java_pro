package HW14;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static <T> List<?> toList(T[] array){
        List<T> list = new ArrayList<>();
        for (T a: array) {
            list.add(a);
        }
        return list;
    }
}
