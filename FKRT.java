package readability;

public class FKRT {

    public static void runFKRT(FileDecomposer file) {
        calculateFKRT(file.getNumWords(), file.getNumSentences(), file.getNumSyllables());
    }
    public static void calculateFKRT(int numWords, int numSentences, int numSyllables) {
        double FKRT = (0.39 * ((double) numWords / numSentences)) + (11.8 * ((double) numSyllables / numWords)) - 15.59;
        printFKRT(FKRT);
    }

    public static void printFKRT(double FKRT) {
        System.out.printf("\nFlesch–Kincaid readability tests: %.2f ", FKRT);
        System.out.printf("(about %s-year-olds).", AgeGroups.upperAge((int) Math.ceil(FKRT)));
    }
}
