package hw6.symbols.and.tests;

import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {
    private static final String[] WORDS = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        String word = WORDS[RandomGenerator.getDefault().nextInt(WORDS.length)];

        System.out.println("Word: " + word);

        var scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.print("Insert your word: ");
            var guess = scanner.nextLine();

            var result = GuessGame.play(word, guess);

            switch (result.result()) {
                case WIN -> running = false;
                case LOST -> System.out.println("Try again. Tips: " + result.hint());
            }

        }
        System.out.println("You win!");

    }
}