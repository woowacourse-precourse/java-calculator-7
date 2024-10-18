package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));
    public static String customFormat = "//(.*?)\\\\n(.*)";
    public static String input;
    public static int[] numbers;
    public static int sumValue;

    public static boolean inputIsEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static int[] extractNumbers(String input, List<String> separators) {
        try {
            String separatorsRegex = String.join("|", separators);
            int[] numbers = Arrays.stream(input.split(separatorsRegex)).map(String::trim).mapToInt(Integer::parseInt).toArray();

            for (int number : numbers) {
                if (number < 0) {
                    throw new IllegalArgumentException("문자열 형식이 틀렸습니다.");
                }
            }
            return numbers;
        } catch (Error e) {
            throw new IllegalArgumentException("문자열 형식이 틀렸습니다.");
        }
    }

    public static boolean isCustomSeparator(String input) {
        return input.startsWith("//");
    }

    public static String extractCustomSeparator(String input, List<String> separators) {
        try {
            Matcher matcher = Pattern.compile(customFormat).matcher(input);

            if (matcher.find() && !matcher.group(1).isEmpty()) {
                String customSeparator = matcher.group(1);  // 커스텀 구분자
                String extractNumber = matcher.group(2);  // 나머지 문자열

                if (!Character.isDigit(customSeparator.charAt(0))) {
                    separators.addFirst(Pattern.quote(customSeparator));
                    return extractNumber;
                }
            }
            throw new IllegalArgumentException("커스텀 구분자 형식이 틀렸습니다.");
        } catch (Error e) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 틀렸습니다.");
        }
    }

    public static void displayHelp() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static void displayResult(int sumValue) {
        System.out.println("결과 : " + sumValue);
    }

    public static void main(String[] args) {
        displayHelp();
        input = readLine();

        if (inputIsEmpty(input)) {
            sumValue = 0;
        } else {
            if (isCustomSeparator(input)) {
                input = extractCustomSeparator(input, separators);
            }
            numbers = extractNumbers(input, separators);
            sumValue = sum(numbers);

        }

        displayResult(sumValue);
    }
}
