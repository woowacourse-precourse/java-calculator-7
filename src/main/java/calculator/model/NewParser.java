package calculator.model;

import java.util.regex.Pattern;

public class NewParser {

    // 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를
    // 커스텀 구분자로 사용하여 분리한
    // 각 숫자의 합 반환

    public static int sum(String inputString) {
        int sum = 0;
        String removedString = "";
        String customDelimiter = "";

        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }

        if (inputString.startsWith("//")) {
            if (!inputString.contains("\n")) {
                throw new IllegalArgumentException("커스텀 구분자 조건의 짝이 맞지 않습니다.");
            }

            customDelimiter = inputString.split("\n")[0].substring(2);
            removedString = inputString.split("\n")[1];

            String[] operands = removedString.split(",|:|" + Pattern.quote(customDelimiter));

            for (String operand : operands) {
                int number = Integer.parseInt(operand);

                if (number <= 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                sum += number;
            }
        }

        return sum;
    }
}
