package hw14.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {
    public static <T> List<?> toList(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
