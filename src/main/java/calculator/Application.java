package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        try {
            int result = calculateSum(inputString);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static int calculateSum(String input) {
        if (isEmptyInput(input)) {
            return 0;
        }

        String delimiter = getDelimiter(input);
        String numbers = getNumbersString(input, delimiter);
        String[] numberArray = numbers.split(delimiter);

        return sumNumbers(numberArray);
    }

    public static boolean isEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    public static String getDelimiter(String input) {
        Pattern customDelimiterPattern = Pattern.compile("//(.*)\\\\n(.*)");
        Matcher matcher = customDelimiterPattern.matcher(input);

        if (matcher.matches()) {
            String delimiter = Pattern.quote(matcher.group(1));
            return delimiter + "|,|:";
        }

        return ",|:";
    }

    public static String getNumbersString(String input, String delimiter) {
        if (input.startsWith("//")) {
            String[] parts = input.split("\\\\n", 2);
            if (parts.length < 2 || parts[1].isEmpty()) {
                throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
            }
            return parts[1];
        }
        return input;
    }

    public static int sumNumbers(String[] numberArray) {
        int total = 0;
        for (String numberStr : numberArray) {
            int number = parseNumber(numberStr.trim());
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            total += number;
        }
        return total;
    }

    public static int parseNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식이 포함되어 있습니다: " + numberStr);
        }
    }
}
