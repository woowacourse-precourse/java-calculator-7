package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        int result = calculateSum(input);
        System.out.println("결과 : " + result);
    }

    private static int calculateSum(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = determineDelimiter(input);
        input = removeDelimiterHeader(input);
        List<Integer> numbers = parseNumbers(input, delimiter);
        return sumNumbers(numbers);
    }

    private static String determineDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            return extractCustomDelimiter(input);
        }
        return ",|:"; // 기본 구분자
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private static String extractCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.*?)\\\\n").matcher(input);
        if (matcher.find()) {
            return Pattern.quote(matcher.group(1)); // 커스텀 구분자 반환
        }
        throw new IllegalArgumentException("커스텀 구분자가 잘못되었습니다.");
    }

    private static String removeDelimiterHeader(String input) {
        return input.contains("\\n") ? input.split("\\\\n", 2)[1] : input;
    }

    private static List<Integer> parseNumbers(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(Application::convertToInteger)
                .collect(Collectors.toList());
    }

    private static int sumNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static int convertToInteger(String s) {
        int number = parseInteger(s);
        validateNonNegative(number, s);
        return number;
    }

    private static int parseInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되었습니다: " + s);
        }
    }

    private static void validateNonNegative(int number, String originalInput) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + originalInput);
        }
    }
}
