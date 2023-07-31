package HW6;

import java.util.Random;
import java.util.Scanner;
public class Strings {
    private String guessedWord;
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

    public void gameGuess(){
            String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                    "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear",
                    "pepper", "pineapple", "pumpkin", "potato"};
            var random = new Random();
            var scanner = new Scanner(System.in);
            String variants = "Variants: apple, orange, lemon, banana, apricot, avocado, broccoli, carrot, cherry, garlic, grape,\n " +
                    "melon, leak, kiwi, mango, mushroom, nut, olive, pea, peanut, pear, pepper, pineapple, pumpkin, potato";
        System.out.println("Try your variant. " + variants);
            String gWord = scanner.nextLine();
            guessedWord = words[random.nextInt(words.length)];
            while(!gWord.equalsIgnoreCase(guessedWord)){
                System.out.println("Try again\n" + guessedWord.charAt(0) +"" +  guessedWord.charAt(1) +"#############" + "\n" + variants);

                gWord = scanner.nextLine();
            }
            System.out.println("You guessed!");
        }

}