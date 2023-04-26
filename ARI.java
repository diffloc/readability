package readability;

public class ARI {


    public void runARI() {

    }
    public double calculateARI(int numChars, int numWords, int numSentences) {
        return 4.71 * ((double) numChars / numWords) + 0.5 * ((double) numWords / numSentences) - 21.43;
    }

}
