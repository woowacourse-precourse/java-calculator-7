package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_POSTFIX = "\n";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
        }

        input = input.replace("\\n", "\n");

        String[] result = processCustomDelimiter(input);
        String delimiter = result[0];
        String numbers = result[1];

        int sum = sumOfNumbers(numbers, delimiter);
        System.out.println("결과 : " + sum);
    }

    private static String[] processCustomDelimiter(String input) {
        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_POSTFIX);
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterIndex));
            numbers = input.substring(delimiterIndex + 1);
        }

        return new String[] { delimiter, numbers };
    }

    private static int sumOfNumbers(String numbers, String delimiter) {
        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}



