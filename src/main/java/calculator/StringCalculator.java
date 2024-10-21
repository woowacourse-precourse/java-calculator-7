package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,|:]";  // 기본 구분자 (쉼표, 콜론)

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterEndIndex));  // 커스텀 구분자 추출
            input = input.substring(delimiterEndIndex + 2);  // "\n"을 처리했으므로 +2
        }

        // 구분자로 문자열을 분리하고 합산
        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            if (!number.isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }
}
