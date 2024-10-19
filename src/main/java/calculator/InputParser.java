package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public static ParsedInput parse(String input) {
        if(input == null || input.trim().isEmpty()){
            return new ParsedInput(new ArrayList<>());
        }

        String delimiter = DEFAULT_DELIMITERS;
        String numbersString = input;

        // 커스텀 구분자가 있을 경우 처리
        if (input.startsWith("//")) {
            Matcher matcher = CUSTOM_PATTERN.matcher(input);
            if (matcher.find()) {
                delimiter = Delimiter.escape(matcher.group(1));
                numbersString = matcher.group(2);
            }
        }

        return new ParsedInput(parseNumbers(numbersString, delimiter));
    }

    private static List<Integer> parseNumbers(String numbersString, String delimiter) {
        if(numbersString.trim().isEmpty()){
            return new ArrayList<>();
        }

        String[] tokens = numbersString.split(delimiter);
        List<Integer> numbers = new ArrayList<>();

        for(String token : tokens){
            if(!token.trim().isEmpty()){
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
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}