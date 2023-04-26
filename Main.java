package readability;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        FileDecomposer fileDecomposer = new FileDecomposer(args);
        ARI ari = new ARI();
        double score = ari.calculateARI(fileDecomposer.getNumCharacters(), fileDecomposer.getNumWords(), fileDecomposer.getNumSentences());
        String ageRange = AgeGroups.findAgeRange((int) Math.ceil(score));
        System.out.println("The text is:");
        System.out.printf("%s\n\n", fileDecomposer.getText());
        System.out.println("Words: " + fileDecomposer.getNumWords());
        System.out.println("Sentences: " + fileDecomposer.getNumSentences());
        System.out.println("Characters: " + fileDecomposer.getNumCharacters());
        System.out.printf("The score is: %.2f\n", score);
        System.out.printf("This text should be understood by %s year-olds.", ageRange);
    }
}
