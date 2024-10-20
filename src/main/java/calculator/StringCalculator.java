package calculator;

import calculator.exception.InvalidInputException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";

    public static String calculate(String input) {
        if (input == null || input.isEmpty()) {
            return "결과 : 0";
        }

        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        // Step 2: 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new InvalidInputException("잘못된 구분자 형식입니다.");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterIndex));
            numbers = input.substring(delimiterIndex + 2);
        }

        // Step 3: 숫자 추출 및 유효성 검사
        String[] tokens = numbers.split(delimiter + "|,|:");
        List<Integer> parsedNumbers = new ArrayList<>();

        for (String token : tokens) {
            if (token.isEmpty()) {
                // 연속된 구분자로 인해 빈 문자열이 나온 경우, 이를 무시합니다.
                continue;
            }
            try {
                int number = Integer.parseInt(token);
                if (number < 1) {
                    throw new InvalidInputException("숫자는 1 이상이어야 합니다.");
                }
                parsedNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("숫자 이외의 값이 포함되었습니다.");
            }
        }

        // Step 4: 합산
        int sum = parsedNumbers.stream().mapToInt(Integer::intValue).sum();

        return "결과 : " + sum;
    }
}
