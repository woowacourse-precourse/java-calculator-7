package calculator.util.regex;

import static calculator.domain.delimiter.DelimiterPattern.CUSTOM_DELIMITER;

import calculator.domain.delimiter.Delimiter;
import calculator.domain.delimiter.Delimiters;

public class RegexGenerator {

    public Regex makeDelimiterAreaRegex(final Delimiters delimiters) {
        Regex regex = new Regex(CUSTOM_DELIMITER.getRegex());
        for (Delimiter delimiter : delimiters.getDelimiters()) {
            regex.add(delimiter.delimiter());
        }

        return regex;
    }

}
