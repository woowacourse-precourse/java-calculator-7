package calculator.regex;

import static delimiter.DelimiterPattern.CUSTOM_DELIMITER;

import delimiter.Delimiter;
import delimiter.Delimiters;

public class RegexGenerator {

    public Regex makeDelimiterAreaRegex(final Delimiters delimiters) {
        Regex regex = new Regex(CUSTOM_DELIMITER.getRegex());
        for (Delimiter delimiter : delimiters.getDelimiters()) {
            regex.add(delimiter.getDelimiter());
        }

        return regex;
    }

}
