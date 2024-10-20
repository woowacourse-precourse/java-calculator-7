package calculator;

import calculator.exception.InvalidInputException;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static String calculate(String input) {
        if (input == null || input.isEmpty()) {
            return "결과 : 0";
        }

        // Step 1: 구분자 파싱
        List<String> tokens = DelimiterParser.parse(input);
        List<Integer> parsedNumbers = new ArrayList<>();

        // Step 2: 각 숫자 추출 및 유효성 검사
        for (String token : tokens) {
            if (token.isEmpty()) {
                // 연속된 구분자로 인해 빈 문자열이 나온 경우, 이를 무시합니다.
                continue;
            }
            try {
                int number = Integer.parseInt(token);
                if (number < 1) {
                    throw new InvalidInputException("숫자는 1 이상이어야 합니다: " + token);
                }
                parsedNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("숫자 이외의 값이 포함되었습니다: " + token);
            }
        }

        // Step 3: 합산
        int sum = parsedNumbers.stream().mapToInt(Integer::intValue).sum();

        return "결과 : " + sum;
    }
}
