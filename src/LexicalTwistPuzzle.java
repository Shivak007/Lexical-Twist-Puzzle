import java.util.Scanner;

public class LexicalTwistPuzzle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Lexical Twist Puzzle");
        System.out.print("Enter first word: ");
        String firstWord = sc.nextLine();

        System.out.print("Enter second word: ");
        String secondWord = sc.nextLine();

        if (firstWord.contains(" ")) {
            System.out.println(firstWord + " is an invalid word");
            return;
        }

        if (secondWord.contains(" ")) {
            System.out.println(secondWord + " is an invalid word");
            return;
        }

        String reversed = new StringBuilder(firstWord).reverse().toString();

        if (reversed.equalsIgnoreCase(secondWord)) {

            String transformed = reversed
                    .toLowerCase()
                    .replaceAll("[aeiou]", "@");

            System.out.println(transformed);

        } else {

            String combined = (firstWord + secondWord).toUpperCase();

            int vowels = 0;
            int consonants = 0;

            for (char ch : combined.toCharArray()) {
                if ("AEIOU".indexOf(ch) != -1) {
                    vowels++;
                } else if (Character.isLetter(ch)) {
                    consonants++;
                }
            }

            if (vowels > consonants) {

                String result = "";
                for (char ch : combined.toCharArray()) {
                    if ("AEIOU".indexOf(ch) != -1 && !result.contains(ch + "")) {
                        result += ch;
                    }
                    if (result.length() == 2) break;
                }
                System.out.println(result);

            } else if (consonants > vowels) {

                String result = "";
                for (char ch : combined.toCharArray()) {
                    if ("AEIOU".indexOf(ch) == -1 &&
                            Character.isLetter(ch) &&
                            !result.contains(ch + "")) {

                        result += ch;
                    }
                    if (result.length() == 2) break;
                }
                System.out.println(result);

            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }
    }
}
