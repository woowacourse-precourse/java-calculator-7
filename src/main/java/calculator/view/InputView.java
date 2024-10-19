package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final String DEFAULT_NUMBER_DELIMITER_REGEX = "[,:]";

    private InputView() {
    }

    public static List<Integer> inputNumbers() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = input();
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return splitNumbersWithCustomDelimiter(input);
        }
        return splitNumbers(input, DEFAULT_NUMBER_DELIMITER_REGEX);
    }

    private static String input() {
        String input = Console.readLine();
        System.out.println(input);
        return input;
    }

    private static List<Integer> splitNumbersWithCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return splitNumbers(numbers, Pattern.quote(delimiter));
        } else {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
    }

    private static List<Integer> splitNumbers(String numbers, String delimiterRegex) {
        return Arrays.stream(numbers.split(delimiterRegex))
                .map(InputView::toInt)
                .toList();
    }

    private static int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("형식이 올바르지 않습니다.", e);
        }
    }
}
