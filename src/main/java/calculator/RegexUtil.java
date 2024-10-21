package calculator;

import java.util.Set;

public class RegexUtil {

    private static String digitsAndDelimitersPattern(Set<Character> delimiters) {
        return "[0-9" + concatDelimiters((delimiters)) + "]*$";
    }

    private static String delimitersPattern(Set<Character> delimiters) {
        return "[" + concatDelimiters((delimiters)) + "]";
    }

    public static boolean isDigitsAndDelimitersOnly(String string, Set<Character> delimiters) {
        String regex = digitsAndDelimitersPattern(delimiters);
        return string.matches(regex);
    }

    public static String[] splitByDelimiters(String string, Set<Character> delimiters) {
        String regex = delimitersPattern(delimiters);
        return string.split(regex);
    }

    private static String concatDelimiters(Set<Character> delimiters) {
        StringBuilder concatedDelimiters = new StringBuilder();

        for (Character delimiter : delimiters) {
            if (!Character.isLetterOrDigit(delimiter)) {
                concatedDelimiters.append("\\");
            }
            concatedDelimiters.append(delimiter);
        }

        return concatedDelimiters.toString();
    }

}
