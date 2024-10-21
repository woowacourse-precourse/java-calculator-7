package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculateSum(input);
        System.out.println("결과 : " + result);
    }

    private static int calculateSum(String input) {
        if (input.isEmpty()) {
            return 0;  // 빈 문자열 처리
        }
        String delimiter = getDelimiter(input);
        String numbersString = getNumbersString(input);
        List<Integer> numbers = parseNumbers(numbersString, delimiter);
        return sumNumbers(numbers);
    }

    private static String getDelimiter(String input) {
        if (input.startsWith("//")) {
            return extractCustomDelimiter(input);
        }
        return ",|:";
    }

    private static String extractCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.*?)\\\\n").matcher(input);
        if (matcher.find()) {
            return Pattern.quote(matcher.group(1));
        }
        throw new IllegalArgumentException("커스텀 구분자가 잘못되었습니다.");
    }

    private static String getNumbersString(String input) {
        return input.replaceFirst("//.*?\\\\n", "");
    }

    private static List<Integer> parseNumbers(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(Application::parseInt)
                .collect(Collectors.toList());
    }

    private static int sumNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private static int parseInt(String s) {
        validateNumber(s);
        return Integer.parseInt(s);
    }

    private static void validateNumber(String s) {
        if (s.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 허용되지 않습니다.");
        }
        try {
            int number = Integer.parseInt(s);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + s);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되었습니다: " + s);
        }
    }
}
