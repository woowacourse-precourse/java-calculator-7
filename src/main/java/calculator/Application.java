package calculator;

import java.util.Scanner;

public class Application {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEWLINE = "\\n";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        int result = calculateSum(input);
        System.out.println("결과 : " + result);

        sc.close();
    }

    public static int calculateSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String[] numbers = extractNumbers(input);
        validateNumbers(numbers);

        return sumNumbers(numbers);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] extractNumbers(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return splitUsingCustomDelimiter(input);
        }
        return input.split(DEFAULT_DELIMITERS);
    }

    private static String[] splitUsingCustomDelimiter(String input) {
        int newlineIndex = input.indexOf(NEWLINE);
        if (newlineIndex == -1) {
            throw new IllegalArgumentException("잘못된 형식입니다. 구분자와 숫자 사이에 \\n이 필요합니다.");
        }

        String delimiter = input.substring(2, newlineIndex);
        String numbersPart = input.substring(newlineIndex + 2);
        return numbersPart.split(delimiter);
    }

    private static void validateNumbers(String[] numbers) {
        for (String num : numbers) {
            if (!num.matches("-?\\d+")) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + num);
            }
            if (Integer.parseInt(num.trim()) < 0) {
                throw new IllegalArgumentException("음수가 포함되어 있습니다: " + num);
            }
        }
    }

    private static int sumNumbers(String[] numbers) {
        int result = 0;
        for (String num : numbers) {
            result += Integer.parseInt(num.trim());
        }
        return result;
    }
}