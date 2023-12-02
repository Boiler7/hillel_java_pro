package bank;

import java.util.Random;

public class NumberGenerator {
    public static String generateIBAN(){
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 25; i++) {
            int randomNumber = random.nextInt(10);
            result.append(randomNumber);
        }

        return result.toString();
    }

}
