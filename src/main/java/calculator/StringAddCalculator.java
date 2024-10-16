package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    // 기본 구분자: , 또는 :
    private static String delimiter = "[,|:]";
    private static int result = 0;

    private static final int CUSTOM_DELIMITER_ORDER = 1;
    private static final int ARITHMETIC_EXPRESSION_ORDER = 2;
    // ex) 커스텀 구분자를 ;로 정했을 때, //;\n1;2;3
    private static final String CUSTOM_REGEX = "//(.)\\\\n(.*)";

    public static int add(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        return sum(parseCustomDelimiter(input));
    }

    public int add1(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        // 1. input 에서 커스텀 구분자와 계산식을 추출한다
        String[] delimiterAndNumbers = extractCustomDelimiterAndNumbers(input);
        String delimiters = delimiterAndNumbers[0];
        String numbersString = delimiterAndNumbers[1];
        // 2. 계산식에서 숫자들을 추출한다
        List<Integer> numbers = splitNumbers(delimiters, numbersString);
        // 3. 추출된 숫자들 중 음수가 있는지 검증한다
        validateNumbers(numbers);
        // 4. 숫자들을 더한 값들을 반환한다
        return sum1(numbers);
    }

    private String[] extractCustomDelimiterAndNumbers(String input) {
        String delimiters = delimiter;
        String numbersString = input;

        Pattern pattern = Pattern.compile(CUSTOM_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_ORDER);
            numbersString = matcher.group(ARITHMETIC_EXPRESSION_ORDER);
            // TODO: Pattern.quote() 로직을 검증하라
            delimiters += "|" + Pattern.quote(customDelimiter);
        }
        return new String[]{delimiters, numbersString};
    }

    private List<Integer> splitNumbers(String delimiters, String numbersString) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitNumbers = numbersString.split(delimiters);
        for (String splitNumber : splitNumbers) {
            numbers.add(Integer.parseInt(splitNumber));
        }
        return numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException(
                        String.format("(%s)는 음수입니다. 입력하는 숫자들은 반드시 양수 혹은 0이어야 합니다.", number)
                );
            }
        }
    }

    private int sum1(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static int sum(String input) {
        String[] numbers = input.split(delimiter);
        for (String number : numbers) {
            if (number == null || number.isBlank()) {
                throw new IllegalArgumentException("구분자 사이에는 숫자가 입력되어야 합니다.");
            }

            int operand = Integer.parseInt(number);
            if (operand < 0) {
                throw new IllegalArgumentException(
                        String.format("(%s)는 음수입니다. 입력하는 숫자들은 반드시 양수 혹은 0이어야 합니다.", operand)
                );
            }
            result += operand;
        }
        return result;
    }

    private static String parseCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            delimiter = matcher.group(CUSTOM_DELIMITER_ORDER);
            input = matcher.group(ARITHMETIC_EXPRESSION_ORDER);
        }
        return input;
    }
}
