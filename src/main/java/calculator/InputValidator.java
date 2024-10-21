package calculator;

import java.util.Set;

public class InputValidator {

    private static DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

    public Set<String> validate(String s) {
        Set<String> delimiters = delimiterExtractor.extract(s);
        if (s.isEmpty()) {
            return delimiters;
        }
        if (!s.startsWith("//") && validateHelper(s, delimiters)) {
            return delimiters;
        }
        if (s.length() >= 5 && s.substring(0, 5).matches("//.\\\\n")) {
            String sub = s.substring(5);
            validateHelper(sub, delimiters);
            return delimiters;
        }
        throw new IllegalArgumentException(ErrorMessage.UNRESOLVED_EXPRESSION.getMsg());
    }

    private boolean validateHelper(String s, Set<String> delimiters) {
        char[] parsed = s.toCharArray();
        for (int i = 0; i < parsed.length; i++) {
            if (48 <= parsed[i] && parsed[i] <= 57) {
                continue;
            }
            boolean isChecked = false;
            for (String token : delimiters) {
                if (String.valueOf(parsed[i]).equals(token)) {
                    isChecked = true;
                    break;
                }
            }
            if (isChecked) {
                continue;
            }
            throw new IllegalArgumentException(ErrorMessage.UNDEFINED_DELIMITER.getMsg());
        }
        return true;
    }
}
