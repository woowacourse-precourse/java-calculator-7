package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");

    public int sum(String input) {
        if (isEmpty(input)) {
            return 0;
        }

        String[] numbers = split(input);
        return calculateSum(numbers);
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private String[] split(String input) {
        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
        input = extractCustomDelimiter(input, delimiters);
        String delimiterRegex = String.join("|", delimiters);
        return input.split(delimiterRegex);
    }

    /*
    parameter : `input` - 사용자 입력
                `delimiters` - 커스텀 구분자를 저장할 리스트
    return : `input` - 앞 부분의 커스텀 구분자 정의를 제외한 사용자 입력
     */
    private String extractCustomDelimiter(String input, List<String> delimiters) {
        if (!input.startsWith("//")) {
            return input;
        }

        Pattern pattern = Pattern.compile("//(.*)\n");
        Matcher matcher = pattern.matcher(input);
        int startNumberIndex = 0;

        while (matcher.find()) {
            String delimiter = matcher.group(1);
            delimiters.add(Pattern.quote(delimiter));
            startNumberIndex = matcher.end();
        }

        return input.substring(startNumberIndex);
    }

    private int parsePositiveNumber(String number) {
        int num = parseInt(number);
        validatePositive(num);
        return num;
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 형식입니다: " + number);
        }
    }

    private void validatePositive(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수 입력은 불가능합니다: " + num);
        }
    }

    private int calculateSum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(this::parsePositiveNumber)
                .sum();
    }
}
