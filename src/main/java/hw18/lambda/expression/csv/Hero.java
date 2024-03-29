package hw18.lambda.expression.csv;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;


@Getter
@AllArgsConstructor
public class Hero{
    private String name;
    private String gender;
    private String eyeColor;
    private String race;
    private String hairColor;
    private double height;
    private String publisher;
    private String skinColor;
    private String alignment;
    private double weight;
    public static double getAverageHigh(List<Hero> heroes) {
        return heroes.stream()
                .mapToDouble(Hero::getHeight)
                .average()
                .orElse(0);
    }


    public static String getNameOfHighest(List<Hero> heroes){
        return heroes.stream()
                .max(Comparator.comparingDouble(Hero::getHeight))
                .map(Hero::getName)
                .orElse("No heroes found");
    }

    public static String getNameOfHeaviest(List<Hero> heroes){
        return heroes.stream()
                .max(Comparator.comparingDouble(Hero::getWeight))
                .map(Hero::getName)
                .orElse("No hero found");
    }

    public static Map<String, Integer> getPersonsGenderGroup(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getGender, Collectors.summingInt(e -> 1)));
    }
    public static Map<String, Integer> getPersonsAlignment(List<Hero> heroes){
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getAlignment, Collectors.summingInt(e -> 1)));
    }


    public static List<String> get5PopularPublishers(List<Hero> heroes){
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getPublisher, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> get3PopularHairColor(List<Hero> heroes){
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getHairColor, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static String getPopularEyeColor(List<Hero> heroes){
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getEyeColor, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No hero found");
    }
}
