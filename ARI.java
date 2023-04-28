package readability;

public class ARI {


    public static void runARI(FileDecomposer file) {
        calculateARI(file.getNumCharacters(), file.getNumWords(), file.getNumSentences());
    }
    public static void calculateARI(int numChars, int numWords, int numSentences) {
        double ARI = 4.71 * ((double) numChars / numWords) + 0.5 * ((double) numWords / numSentences) - 21.43;
        printARI(ARI);
    }

    public static void printARI(double ARI) {
        System.out.printf("\nAutomated Readability Index: %.2f ", ARI);
        System.out.printf("(about %s-year-olds).", AgeGroups.upperAge((int) Math.ceil(ARI)));
    }
}
