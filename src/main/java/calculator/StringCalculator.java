package calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    public String[] splitInput(String input) {
        // 입력이 null이면 예외를 던짐
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }

        // 커스텀 구분자를 사용한 경우
        if (input.startsWith("//")) {
            int customIdx = input.indexOf("\n");
            if (customIdx == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            String custom = input.substring(2, customIdx);
            String numberString = input.substring(customIdx + 1);
            if (custom.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
            }
            return numberString.split(Pattern.quote(custom));
        }
        // 기본 구분자 (쉼표, 콜론)를 사용한 경우
        return input.split("[,:]");
    }

    public int caculate(String input) {
        // 입력이 null이거나 빈 문자열인 경우 0을 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitInput(input);
        int sum = 0;

        // 각 문자열을 숫자로 변환하여 합산
        for (String number : numbers) {
            int num;
            try {
                num = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다: " + number);
            }

            // 음수 값이 있는 경우 예외를 던짐
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            sum += num;
        }

        return sum;
    }
}
