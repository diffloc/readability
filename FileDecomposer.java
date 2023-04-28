package readability;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDecomposer {

    private int numWords;
    private int numSentences;
    private int numCharacters;
    private int numSyllables;
    private int numPolySyllables;

    private String[] words;
    private String text;

    public FileDecomposer(String[] args) {
        setText(args);
        setNumCharacters();
        setNumSentences();
        setNumWords();
        setNumSyllables();
        setNumPolySyllables();
    }

    public void setText(String[] args) {
//        this.text = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[1024 * 1024]; // Read 1 MB at a time
            int length;
            while ((length = reader.read(buffer)) != -1) {
                builder.append(buffer, 0, length);
            }
            this.text = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void splitWords() {
        this.words = this.text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    }


    public void setNumWords() {
        splitWords();
        this.numWords = this.words.length;
    }

    public void setNumSentences() {
        String[] sentences = this.text.split("[.!?]\\s+");
        this.numSentences = sentences.length;
    }

    public void setNumCharacters() {
        String visibleChars = this.text.replaceAll("\\s+", "");
        this.numCharacters = visibleChars.length();
    }

    public static int calculateWordSyllables(String word) {

        int numVowels = 0;
        boolean lastWasVowel = false;
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            boolean isVowel = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
            if (isVowel && !lastWasVowel) {
                numVowels++;
                lastWasVowel = true;
            } else if (isVowel) {
                lastWasVowel = true;
            } else {
                lastWasVowel = false;
            }
        }
        if (word.endsWith("e")) {
            numVowels--;
        }
        if (numVowels == 0) {
            numVowels = 1;
        }
        return numVowels;
    }

    public void setNumSyllables() {
        int numSyllables = 0;
        for (String word: this.words) {
            numSyllables += calculateWordSyllables(word);
        }
        this.numSyllables = numSyllables;
    }

    public void setNumPolySyllables() {
        int countPolysyllables = 0;
        for (String word : this.words) {
            int numSyllables = calculateWordSyllables(word);
            if (numSyllables > 2) {
                countPolysyllables++;
            }
        }
        this.numPolySyllables = countPolysyllables;
    }

    public int getNumWords() {
        return numWords;
    }

    public int getNumSentences() {
        return numSentences;
    }

    public int getNumCharacters() {
        return numCharacters;
    }

    public int getNumSyllables() {
        return numSyllables;
    }

    public int getNumPolySyllables() {
        return numPolySyllables;
    }

    public String getText() {
        return text;
    }

    public void printStats() {
        System.out.println("The text is:");
        System.out.printf("%s\n\n", getText());
        System.out.println("Words: " + getNumWords());
        System.out.println("Sentences: " + getNumSentences());
        System.out.println("Characters: " + getNumCharacters());
        System.out.println("Syllables: " + getNumSyllables());
        System.out.println("Polysyllables: " + getNumPolySyllables());
    }
}
