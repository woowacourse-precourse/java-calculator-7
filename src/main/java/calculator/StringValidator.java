package calculator;

import java.util.Set;

public class StringValidator {

    public void validate(String string, Set<Character> delimiters) {
        String regex = regexPattern(delimiters);

        if (!string.isEmpty() && !string.matches(regex)) {
            throw new IllegalArgumentException("구분자가 아닌 문자가 있습니다");
        }
    }

    private String regexPattern(Set<Character> delimiters) {
        StringBuilder regex = new StringBuilder("[0-9");
        for (Character delimiter : delimiters) {
            if (!Character.isLetterOrDigit(delimiter)) {
                regex.append("\\");
            }
            regex.append(delimiter);
        }

        regex.append("]+$");
        return regex.toString();
    }

}
