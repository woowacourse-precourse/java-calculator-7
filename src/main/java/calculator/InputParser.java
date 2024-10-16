package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");


    public static List<Integer> parse(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        String delimiters = DEFAULT_DELIMITERS;
        String numbersString = input;

        if (matcher.matches()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            delimiters = DEFAULT_DELIMITERS + "|" + customDelimiter;
            numbersString = matcher.group(2);

        }

        String[] tokens = numbersString.split(delimiters);
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            if (!token.matches("\\d+")) {
                throw new IllegalArgumentException("양수 이외의 값이 포함되어 있습니다.");
            }
            numbers.add(Integer.parseInt(token));

        }

        return numbers;

        }


}
