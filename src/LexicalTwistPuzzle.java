import java.util.Scanner;

public class LexicalTwistPuzzle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        WordValidator validator = new WordValidator();
        LexicalAnalyzer analyzer = new LexicalAnalyzer();

        System.out.println("Lexical Twist Puzzle");

        System.out.print("Enter first word: ");
        String firstWord = sc.nextLine();

        System.out.print("Enter second word: ");
        String secondWord = sc.nextLine();

        if (!validator.isValid(firstWord)) {
            System.out.println(firstWord + " is an invalid word");
            return;
        }

        if (!validator.isValid(secondWord)) {
            System.out.println(secondWord + " is an invalid word");
            return;
        }

        if (analyzer.isReverse(firstWord, secondWord)) {
            System.out.println(analyzer.transform(firstWord));
        } else {
            System.out.println(analyzer.analyze(firstWord, secondWord));
        }
    }
}
