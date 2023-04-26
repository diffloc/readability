package readability;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDecomposer {

    private int numWords;
    private int numSentences;
    private int numCharacters;
    private String text;

    public FileDecomposer(String[] args) {
        setText(args);
        setNumCharacters();
        setNumSentences();
        setNumWords();
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

    public void setNumWords() {
        String[] words = this.text.split("\\s+");
        this.numWords = words.length;
    }

    public void setNumSentences() {
        String[] sentences = this.text.split("[.!?]\\s+");
        this.numSentences = sentences.length;
    }

    public void setNumCharacters() {
        String visibleChars = this.text.replaceAll("\\s+", "");
        this.numCharacters = visibleChars.length();
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

    public String getText() {
        return text;
    }
}
