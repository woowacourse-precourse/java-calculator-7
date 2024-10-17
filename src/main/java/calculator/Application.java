package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

public class Application {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";


    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // 사용자 입력

        int result = add(input);
        System.out.println("결과 : " + result);

    }

    public static int add(String input) {
        String safeInput = Optional.ofNullable(input).orElse("");
        if (safeInput.isEmpty()) {
            return 0;
        }

        String[] parts = parseInput(safeInput);
        String delimiter = parts[0];
        String numbersString = parts[1];

        String[] numbers = numbersString.split(delimiter);

        validateNumbers(numbers);
        return calculateSum(numbers);
    }

    private static String[] parseInput(String input) {
        String delimiter = DEFAULT_DELIMITER;
        String numbersString = input;

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int newlineIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다. '//구분자\\n' 형식을 사용해야 합니다.");
            }
            String customDelimiter = extractCustomDelimiter(input, newlineIndex);
            delimiter += "|" + customDelimiter;
            numbersString = input.substring(newlineIndex + 2);
        }

        return new String[]{delimiter, numbersString};
    }

    // 커스텀 구분자를 추출하는 로직을 별도 메서드로 분리
    private static String extractCustomDelimiter(String input, int newlineIndex) {
        return Pattern.quote(input.substring(2, newlineIndex));
    }

    private static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (!number.matches("-?\\d+")) {
                throw new IllegalArgumentException("숫자 형식이 잘못되었습니다: " + number);
            }
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
        }
    }

    private static int calculateSum(String[] numbers) {
        return Arrays.stream(numbers)
                .filter(number -> !number.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
