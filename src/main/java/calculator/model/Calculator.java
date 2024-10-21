package calculator.model;

import java.util.List;

public class Calculator {

    public int calculateSum(List<String> tokens) {
        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                int number = parseNumber(token);
                sum += number;
            }
        }
        return sum;
    }

    private int parseNumber(String numberStr) {
        if (!isNumeric(numberStr)) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
        }

        int number = Integer.parseInt(numberStr);

        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
        return number;
    }

    private boolean isNumeric(String str) {
        // 숫자 여부를 확인하는 정규식 패턴
        return str.matches("-?\\d+");
    }
}