package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEW_LINE_INDICATOR = "\\n";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
        processInput(userInput);
    }

    public static void processInput(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다. 빈 문자열을 입력할 수 없습니다.");
        }

        List<Long> numbers = new ArrayList<>();
        String delimiter;

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int idx = input.indexOf(NEW_LINE_INDICATOR);
            if (idx > 0) {
                delimiter = getCustomDelimiter(input);
                input = input.substring(idx + 2).trim();
            } else {
                throw new IllegalArgumentException("커스텀 구분자가 잘못 지정되었습니다.");
            }
        } else {
            delimiter = determineDelimiter(input);
        }

        String[] inputArray = input.split(delimiter);
        Arrays.stream(inputArray).forEach(s -> {
            try {
                long number = Long.valueOf(s.trim());
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다: '" + s.trim() + "'");
            }
        });

        checkForNegativeNumbers(numbers);
        displayResult(calculateSum(numbers));
    }

    private static String getCustomDelimiter(String input) {
        int idx = input.indexOf(NEW_LINE_INDICATOR);
        return input.substring(2, idx);
    }

    public static String determineDelimiter(String input) {
        if (!input.contains(";") && !input.contains(",")) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다. 쉼표 또는 세미콜론을 포함해야 합니다.");
        }
        return input.contains(";") ? ";" : ",";
    }

    public static void checkForNegativeNumbers(List<Long> numbers) {
        for (Long number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
    }

    public static void displayResult(long value) {
        System.out.println("결과 : " + value);
    }

    public static long calculateSum(List<Long> numbers) {
        return numbers.stream().mapToLong(Long::longValue).sum();
    }
}
