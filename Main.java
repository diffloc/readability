package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String file = null;
        try {
            file = Files.readString(Path.of(args[0]));
        } catch (NullPointerException | IOException e) {
            System.out.println("Error: " + e);
        }
        String visibleChars = file.replaceAll("\\s+", "");
        String[] words = file.split("\\s+");
        String[] sentences = file.split("[.!?]\\s+");

        System.out.println("The text is:");
        System.out.printf("%s\n\n", file);
        System.out.println("Words: " + words.length);
        System.out.println("Sentences: " + sentences.length);
        System.out.println("Characters: " + visibleChars.length());
        double score = 4.71 * ((double) visibleChars.length() / words.length) + 0.5 * ((double) words.length / sentences.length) - 21.43;
        System.out.printf("The score is: %.2f\n", score);

        String ageRange = null;
        Map<Integer, String> ageRanges = new HashMap<>();
        ageRanges.put(1, "5-6");
        ageRanges.put(2, "6-7");
        ageRanges.put(3, "7-8");
        ageRanges.put(4, "8-9");
        ageRanges.put(5, "8-10");
        ageRanges.put(6, "10-11");
        ageRanges.put(7, "11-12");
        ageRanges.put(8, "12-13");
        ageRanges.put(9, "13-14");
        ageRanges.put(10, "14-15");
        ageRanges.put(11, "15-16");
        ageRanges.put(12, "16-17");
        ageRanges.put(13, "17-18");
        ageRanges.put(14, "18-22");

        if (score >= 1 && score <= 14) {
            ageRange = ageRanges.get((int) Math.ceil(score));
        } else {
            ageRange = "NaN";
        }
        System.out.printf("This text should be understood by %s year-olds.", ageRange);
    }
}
