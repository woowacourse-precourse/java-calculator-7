package calculator.util.splitter;

import static calculator.domain.delimiter.DelimiterPattern.CUSTOM_DELIMITER;

import calculator.domain.delimiter.Delimiters;
import calculator.util.regex.Regex;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    public List<String> splitByDelimiters(final String input, final Delimiters delimiters) {
        Regex regex = delimiters.makeDelimitersRegex();

        return Arrays.stream(CUSTOM_DELIMITER.getPattern().split(input))
                .flatMap(s -> Arrays.stream(s.split(regex.getRegex())))
                .toList();
    }

}
