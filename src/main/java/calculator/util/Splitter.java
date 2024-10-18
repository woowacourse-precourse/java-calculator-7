package calculator.util;

import calculator.regex.Regex;
import calculator.regex.RegexGenerator;
import delimiter.Delimiters;

public class Splitter {

    public String[] splitedByDelimiters(final String input, final Delimiters delimiters,
                                        final RegexGenerator regexGenerator) {
        Regex regex = regexGenerator.getExcludingDelimiterAreaRegex(delimiters);

        return input.split(regex.getRegex());
    }

}
