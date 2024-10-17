package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {

    private static final int EMPTY_INPUT_RETURN_VALUE = 0;
    private static final int SIZE_OF_CUSTOM_DELIMITER_END_SIGN = 2;

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // Get input
        String input = readLine();

        int result = getResult(input);

        System.out.println("결과 : " + result);
    }

    private static int getResult(String input) {
        // 비어있을 경우 0을 반환하자 (3.1 예외)
        if (input.isEmpty()) {
            return EMPTY_INPUT_RETURN_VALUE;
        }
        /**
         * 1.1 기본 구분자만 입력된 경우
         */
        StringBuilder delimiterPart = new StringBuilder("[,:]");
        String numberPart = input;

        /**
         * 1.2 커스텀 구분자를 포함하여 입력된 경우
         */
        if (hasCustomDelimiter(input)) {
            int indexOfEndSign = input.indexOf("\\n"); // 개행문자가 아닌 \n라는 문자를 찾는다
            if (indexOfEndSign == -1) {
                throw new IllegalArgumentException("커스텀 구분자 선언 후 '\\n'이 필요합니다.");
            }

            String customDelimiterPart = input.substring(2, indexOfEndSign);
            String[] customDelimiters = customDelimiterPart.split(""); // 여러 커스텀 구분자 받는 경우 포함

            for (String delim : customDelimiters) {
                delimiterPart.append("|").append(toRegex(delim));
            }

            numberPart = input.substring(indexOfEndSign + SIZE_OF_CUSTOM_DELIMITER_END_SIGN);
        }

        String[] numbers = numberPart.split(delimiterPart.toString());

        validateNoNegativeNumbers(numbers); // 음수 있으면 예외 발생 (3.8 예외)

        return add(numbers);
    }

    private static void validateNoNegativeNumbers(String[] numbers) {
        if (Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .anyMatch(n -> n < 0)) {
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        }
    }

    private static String toRegex(String delim) {
        return Pattern.quote(delim);
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private static int add(String[] numbers) {
        int result = 0;

        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
