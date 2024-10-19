package calculator.util;

import calculator.regex.Regex;
import delimiter.DelimiterPattern;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    public List<String> splitByDelimiters(final String input, final Regex regex) {

        return Arrays.stream(DelimiterPattern.CUSTOM_DELIMITER.getPattern().split(input))
                .flatMap(s -> Arrays.stream(s.split(regex.getRegex())))
                .toList();
    }

}
