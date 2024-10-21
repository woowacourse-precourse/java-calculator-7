package calculator.domain;

import calculator.vo.ExceptionMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    private String delimiterRegex = "[,:\\d -]+";
    private String removeDelimiterRegex = "[,:]";

    public String removeDelimiter(String input) {
        Matcher matcher = Pattern.compile(delimiterRegex).matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DELIMITER.getMessage());
        }

        return input.replaceAll(removeDelimiterRegex, " ");
    }

    public void addCustomDelimiter(String newDelimiter) {
        final String target = "]";
        this.delimiterRegex = delimiterRegex.replace(target, newDelimiter + target);
        this.removeDelimiterRegex = removeDelimiterRegex.replace(target, newDelimiter + target);
    }
}
