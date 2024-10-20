package calculator.util.regex;

import calculator.domain.delimiter.DelimiterPattern;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    public List<String> splitByDelimiters(final String input, final Regex regex) {

        return Arrays.stream(DelimiterPattern.CUSTOM_DELIMITER.getPattern().split(input))
                .flatMap(s -> Arrays.stream(s.split(regex.getRegex())))
                .toList();
    }

}
