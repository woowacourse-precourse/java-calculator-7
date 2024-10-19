package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public static ParsedInput parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new ParsedInput(new ArrayList<>());
        }

        input = input.replace("\\n", "\n");

        if (input.startsWith("//")) {
            return parseWithCustomDelimiter(input);
        }

        return parseWithDefaultDelimiter(input);
    }

    private static ParsedInput parseWithCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
        }

        String delimiter = Pattern.quote(matcher.group(1));
        String numbers = matcher.group(2);
        return new ParsedInput(parseNumbers(numbers, delimiter));
    }

    private static ParsedInput parseWithDefaultDelimiter(String input) {
        return new ParsedInput(parseNumbers(input, DEFAULT_DELIMITERS));
    }

    private static List<Integer> parseNumbers(String numbersString, String delimiter) {
        if (numbersString.trim().isEmpty()) {
            return new ArrayList<>();
        }

        String[] tokens = numbersString.split(delimiter);
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                int number = parseNumber(token.trim());
                NumberValidator.validate(number);
                numbers.add(number);
            }
        }

        return numbers;
    }

    private static int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 잘못되었습니다: " + token);
        }
    }
}