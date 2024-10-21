package calculator.Model;

import calculator.Utils.StringUtils;

public class Calculator {

    public int add(String input) {
        if (input.trim().isEmpty()) {
            return 0;
        }

        // Util 클래스를 사용하여 문자열을 분리
        String[] numbers = StringUtils.splitInput(input, "[,|:]");
        int sum = 0;
        for (String number : numbers) {
            sum += parseInt(number);
        }
        return sum;
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + number);
        }
    }
}