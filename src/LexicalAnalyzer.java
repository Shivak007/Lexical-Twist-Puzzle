import java.util.LinkedHashSet;

public class LexicalAnalyzer {

    public boolean isReverse(String w1, String w2) {
        String reversed = new StringBuilder(w1).reverse().toString();
        return reversed.equalsIgnoreCase(w2);
    }

    public String transform(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        return reversed.toLowerCase().replaceAll("[aeiou]", "@");
    }

    public String analyze(String w1, String w2) {

        String combined = (w1 + w2).toUpperCase();
        int vowels = 0;
        int consonants = 0;

        for (char ch : combined.toCharArray()) {
            if ("AEIOU".indexOf(ch) != -1) vowels++;
            else if (Character.isLetter(ch)) consonants++;
        }

        if (vowels > consonants) {
            return firstUnique(combined, true);
        } else if (consonants > vowels) {
            return firstUnique(combined, false);
        } else {
            return "Vowels and consonants are equal";
        }
    }

    private String firstUnique(String word, boolean vowelMode) {

        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char ch : word.toCharArray()) {
            if (vowelMode && "AEIOU".indexOf(ch) != -1) set.add(ch);
            if (!vowelMode && "AEIOU".indexOf(ch) == -1 && Character.isLetter(ch)) set.add(ch);
            if (set.size() == 2) break;
        }

        String result = "";
        for (char c : set) result += c;
        return result;
    }
}
