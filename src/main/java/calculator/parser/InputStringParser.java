package calculator.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputStringParser {

    private static final String DEFAULT_DELIMITER_REGEX = ", | :";

    public List<Long> parse(String input) throws IllegalArgumentException{

        Optional<String> customDelimiter= extractCustomDelimiter(input);
        String removedDelimiterInput = customDelimiter.isPresent() ? removeCustomDelimiterFromOriginal(input) : input;
        String delimiterRegex = customDelimiter.isPresent() ? createDelimeterRegex(customDelimiter.get()) : DEFAULT_DELIMITER_REGEX;
        return convertStringToList(removedDelimiterInput, delimiterRegex);
    }

    private List<Long> convertStringToList(String input, String regex) {
        try {
            return Arrays
                    .stream(input.split(regex))
                    .map(Long::parseLong)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private String createDelimeterRegex(String input) {
        return input.chars()
                .mapToObj(c -> "\\" + (char) c)
                .reduce("", (s1,s2) -> s1 + s2);
    }

    private String removeCustomDelimiterFromOriginal(String input) {
        Matcher matcher = getCustomDelimiterMatcher(input);
        if (matcher.find()) {
            return input.substring(matcher.end());
        } else {
            throw new IllegalArgumentException();
        }
    }

    private Optional<String> extractCustomDelimiter(String input) {
        Matcher matcher = getCustomDelimiterMatcher(input);
        return matcher.find() ? Optional.of(matcher.group(1)) : Optional.empty();
    }

    private Matcher getCustomDelimiterMatcher(String input) {
        Pattern pattern = Pattern.compile("^//(.*)\\\\n");
        return pattern.matcher(input);
    }
}
