package HW6;

import java.util.Random;
import java.util.Scanner;
public class Strings {
    public int findSymbolOccurrence(String text, String symbol){
        int before = text.length();
        String newText = text.replace(symbol, "");
        int after = newText.length();
        return (before - after) / symbol.length();
    }

    public int findWordPosition(String source, String target){
        if (source.contains(target)){
            return source.indexOf(target);
        }else {
            return -1;
        }
    }

    public String stringReverse(String text){
        char[] array = text.toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i = text.length()-1; i >=0; i-- ){
            res.append(array[i]);
        }
        return res.toString();
    }
    public boolean isPolindrome(String text) {
        StringBuilder reversedStr = new StringBuilder();

        int lenghtOfText = text.length();

        for (int i = lenghtOfText - 1; i >= 0; i--) {
            reversedStr.append(text.charAt(i));
        }
        return reversedStr.toString().equalsIgnoreCase(text);
    }
}