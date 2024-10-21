package calculator;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public void validate(String[] numbers) {
        List<Integer> negativeNumbers = new ArrayList<>();  // 음수를 저장할 리스트
        for (String number : numbers) {
            if (number.trim().isEmpty()) {
                continue;  // 빈 문자열이나 공백만 있는 문자열은 무시
            }
            int value;
            try {
                value = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + number);
            }
            if (value <= 0) {
                negativeNumbers.add(value);  // 음수와 0일 경우 리스트에 추가
            }
        }

        // 음수가 하나라도 있으면 예외 발생
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("0과 음수는 허용되지 않습니다: " + negativeNumbers);
        }
    }
}
