package readability;

public class SMOG {

    public static void runSMOG(FileDecomposer file) {
        calculateSMOG(file.getNumSentences(), file.getNumPolySyllables());
    }

    public static void calculateSMOG(int numSentences, int numPolySyllables) {
        double SMOG = 1.043 * Math.sqrt(numPolySyllables * ((double) 30 / numSentences)) + 3.1291;
        printCLI(SMOG);
    }

    public static void printCLI(double SMOG) {
        System.out.printf("\nSimple Measure of Gobbledygook: %.2f ", SMOG);
        System.out.printf("(about %s-year-olds).", AgeGroups.upperAge((int) Math.ceil(SMOG)));
    }
}
