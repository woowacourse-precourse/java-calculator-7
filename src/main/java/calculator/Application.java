package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {

    private static final int EMPTY_INPUT_RETURN_VALUE = 0;
    private static final String CUSTOM_DELIMITER_START_SIGN = "//";
    private static final String CUSTOM_DELIMITER_END_SIGN = "\\n";
    private static final int CUSTOM_DELIMITER_END_SIGN_LENGTH = CUSTOM_DELIMITER_END_SIGN.length();

    public static void main(String[] args) {
        printInputMessage();

        String input = readLine();

        int result = getResult(input);

        printResultMessage(result);
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
            int indexOfEndSign = input.indexOf(CUSTOM_DELIMITER_END_SIGN); // 개행문자가 아닌 \n라는 문자를 찾는다
            if (indexOfEndSign == -1) {
                throw new IllegalArgumentException("커스텀 구분자 선언 후 '\\n'이 필요합니다.");
            }

            String customDelimiterPart = input.substring(2, indexOfEndSign);
            String[] customDelimiters = customDelimiterPart.split(""); // 여러 커스텀 구분자 받는 경우 포함

            for (String delim : customDelimiters) {
                delim = delim.trim();
                if (!delim.isEmpty()) {
                    delimiterPart.append("|")
                            .append(toRegex(delim.trim()));
                }
            }

            numberPart = input.substring(indexOfEndSign + CUSTOM_DELIMITER_END_SIGN_LENGTH);
        }

        String[] numbers = numberPart.split(delimiterPart.toString());
        /*
        여러개의 구분자가 연속될 경우 빈 문자열이 리스트에 들어갈 수 있다.
        e.g. 1,,2,3의 경우 numbers List에는 [1, "", 2, 3] 이 들어가게 된다.

        -> validateNoNegativeNumbers, add 메서드에서 빈 문자열에 대한 처리로직을 추가해주어야한다.
        */

        validateNoNegativeNumbers(numbers); // 음수 있으면 예외 발생 (3.8 예외)

        return add(numbers);
    }

    private static void validateNoNegativeNumbers(String[] numbers) {
        if (Arrays.stream(numbers)
                .filter(Application::isNotEmpty)
                .map(String::trim) // 공백 포함 시 예외 처리 3.9
                .mapToInt(Integer::parseInt)
                .anyMatch(n -> n < 0)) {
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        }
    }

    private static boolean isNotEmpty(String n) {
        return !n.trim().isEmpty();
    }

    private static String toRegex(String delim) {
        return Pattern.quote(delim);
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_START_SIGN);
    }

    private static int add(String[] numbers) {
        int result = 0;

        for (String number : numbers) {
            if (number.isEmpty()) {
                continue; // 빈 문자열 무시
            }

            result += Integer.parseInt(number.trim()); // 공백 포함 시 예외 처리 3.9
        }

        return result;
    }

    private static void printInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private static void printResultMessage(int result) {
        System.out.println("결과 : " + result);
    }
}
