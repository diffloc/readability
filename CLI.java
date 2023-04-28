package readability;

public class CLI {

    public static void runCLI(FileDecomposer file) {
        calculateCLI(file.getNumCharacters(), file.getNumWords(), file.getNumSentences());
    }

    public static void calculateCLI(int numChars, int numWords, int numSentences) {
        double L = (double) numChars / numWords * 100;
        double S = (double) numSentences / numWords * 100;
        double CLI = 0.0588 * L - 0.296 * S -15.8;
        printCLI(CLI);
    }

    public static void printCLI(double CLI) {
        System.out.printf("\nColeman–Liau index: %.2f ", CLI);
        System.out.printf("(about %s-year-olds).", AgeGroups.upperAge((int) Math.ceil(CLI)));
    }

}
