package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        Scanner scanner = new Scanner(System.in);
        FileDecomposer file = new FileDecomposer(args);
        file.printStats();

        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "ARI" -> ARI.runARI(file);
            case "FK" -> FKRT.runFKRT(file);
            case "SMOG" -> SMOG.runSMOG(file);
            case "CL" -> CLI.runCLI(file);
            case "all" -> runAll(file);
            default -> System.out.println("NOT VALID INPUT!");
        }
    }

    public static void runAll(FileDecomposer file) {
        ARI.runARI(file);
        FKRT.runFKRT(file);
        SMOG.runSMOG(file);
        CLI.runCLI(file);
    }
}
