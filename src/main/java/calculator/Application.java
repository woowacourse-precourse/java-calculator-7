package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static final String CUSTOM_SEPARATOR_START = "//";
    public static final String CUSTOM_SEPARATOR_END = "\\\\n";
    public static final String CUSTOM_FORMAT = CUSTOM_SEPARATOR_START + "(.*?)" + CUSTOM_SEPARATOR_END + "(.*)";

    public static List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));

    public static boolean inputIsEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static int[] extractNumbers(String input, List<String> separators) {
        try {
            String separatorsRegex = String.join("|", separators);
            return Arrays.stream(input.split(separatorsRegex))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .peek(Application::validateNonNegative)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }

    public static void validateNonNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }

    public static boolean hasCustomSeparator(String input) {
        return input.startsWith(CUSTOM_SEPARATOR_START);
    }

    public static String parseCustomSeparator(String input, List<String> separators) {
            Matcher matcher = Pattern.compile(CUSTOM_FORMAT).matcher(input);

            if (matcher.find() && !matcher.group(1).isEmpty()) {
                String customSeparator = matcher.group(1);  // 커스텀 구분자
                String remainingInput = matcher.group(2);  // 나머지 문자열

                if (!Character.isDigit(customSeparator.charAt(0))) {
                    separators.addFirst(Pattern.quote(customSeparator));
                    return remainingInput;
                }
            }
            throw new IllegalArgumentException("커스텀 구분자 형식이 틀렸습니다.");
    }

    public static void printInstructions() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static void printResult(int sumValue) {
        System.out.println("결과 : " + sumValue);
    }

    public static int calculateSum(String input, List<String> separators) {
        if (inputIsEmpty(input)) {
            return 0;
        }

        if (hasCustomSeparator(input)) {
            input = parseCustomSeparator(input, separators);
        }

        int[] numbers = extractNumbers(input, separators);
        return sum(numbers);
    }

    public static void main(String[] args) {
        printInstructions();
        String input = readLine();
        int sumValue = calculateSum(input, separators);
        printResult(sumValue);
    }
}
