package bank;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class NumberGenerator {
    private static final Random random = new Random();
    private static final StringBuilder result = new StringBuilder();
    public static String generateIBAN(){
        for (int i = 0; i < 25; i++) {
            int randomNumber = random.nextInt(10);
            result.append(randomNumber);
        }

        return "UA" + result;
    }

    public static String generatePAN(){
        for (int i = 0; i < 16; i++) {
            int randomNumber = random.nextInt(10);
            result.append(randomNumber);
        }
        return result.toString();
    }

    public static String generatePIN(){
        for (int i = 0; i < 4; i++) {
            int randomNumber = random.nextInt(10);
            result.append(randomNumber);
        }
        return result.toString();
    }

    public static String generateCVV(){
        for (int i = 0; i < 3; i++) {
            int randomNumber = random.nextInt(10);
            result.append(randomNumber);
        }
        return result.toString();
    }

    public static Date generateExpirationDate(){
        var currentDate = LocalDate.now();
        var expirationDate = currentDate.plusYears(3)
                .with(TemporalAdjusters.lastDayOfMonth());

        return Date.from(expirationDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static String getShortExpirationDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String year = String.valueOf(calendar.get(Calendar.YEAR));

        return month +"/" + year.substring(2);
    }

}
