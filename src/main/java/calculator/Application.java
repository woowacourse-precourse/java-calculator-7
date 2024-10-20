package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final String CUSTOM_DELIMITER = "^//(.*)\\\\n(.*)";
    private static final String DEFAULT_DELIMITER = "[:,]";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        Matcher customPatternMatcher = Pattern.compile(CUSTOM_DELIMITER).matcher(userInput);
        boolean isCustomPatternMatch = customPatternMatcher.matches();
        if (isCustomPatternMatch) {
            String delimiter = customPatternMatcher.group(1);
            String quotedDelimiter = Pattern.quote(delimiter);
            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 필요합니다.");
            }
            if (Character.isDigit(delimiter.charAt(0))) {
                throw new IllegalArgumentException("커스텀 구분자는 문자여야 합니다.");
            }
            String strippedTokens = customPatternMatcher.group(2);
            String[] tokens = strippedTokens.split(quotedDelimiter);
            int sum = Arrays.stream(tokens)
                    .filter(string -> !string.isEmpty())
                    .mapToInt(Application::parsePositiveInt)
                    .sum();

            System.out.println("결과 : " + sum);
            return;
        }

        String[] tokens = userInput.split(DEFAULT_DELIMITER);
        int sum = Arrays.stream(tokens)
                .filter(string -> !string.isEmpty())
                .mapToInt(Application::parsePositiveInt)
                .sum();

        System.out.println("결과 : " + sum);
    }

    private static int parsePositiveInt(String str) {
        try {
            int integer = Integer.parseInt(str);
            if (integer < 0) {
                throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
            }
            return integer;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 사용할 수 있습니다.");
        }
    }
}