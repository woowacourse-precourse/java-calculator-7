package calculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public List<Number> parse(final String userInput) {
        String input = userInput;
        String regex = "//(.*?)\\\\n";
        String delimiter = getDelimiter(input, regex);

        if (isCustomDelimiter(input)) {
            input = input.replaceAll(regex, "");
        }

        String[] tokens = splitInput(input, delimiter);

        return getNumbers(tokens);
    }

    private List<Number> getNumbers(final String[] tokens) {
        List<Number> numbers = new ArrayList<>();

        for (String token : tokens) {
            Number number = parseNumber(token);
            validateNegative(number);
            numbers.add(parseNumber(token));
        }

        return numbers;
    }

    private Number parseNumber(String token) {
        if (token.isEmpty()) {
            return 0;
        }

        try {
            if (token.contains(".")) {
                return Double.parseDouble(token);
            } else {
                return Integer.parseInt(token);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 프로그램을 종료합니다.");
        }
    }

    private String[] splitInput(String input, String delimiter) {
        String[] tokens = input.split(delimiter);

        if (tokens.length == 1 && tokens[0].equals(input)) {
            try {
                parseNumber(tokens[0]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자를 사용하지 않았습니다. 프로그램을 종료합니다.");
            }
        }

        return tokens;
    }

    private String getDelimiter(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String delimiter = "[,:]";

        if (matcher.find()) {
            delimiter = Pattern.quote(matcher.group(1));
        }

        return delimiter;
    }

    private boolean isCustomDelimiter(String userInput) {
        return userInput.startsWith("//") && userInput.startsWith("\\n", 3);
    }

    private void validateNegative(Number number) {
        if (number.doubleValue() < 0) {
            throw new IllegalArgumentException("음수를 입력하였습니다. 프로그램을 종료합니다.");
        }
    }
}
