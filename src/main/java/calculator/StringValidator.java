package calculator;

import java.util.Set;

public class StringValidator {

    public void validate(String string, Set<Character> delimiters) {
        if (!RegexUtil.isDigitsAndDelimitersOnly(string, delimiters)) {
            throw new IllegalArgumentException("구분자가 아닌 문자가 있습니다");
        }
    }

}
