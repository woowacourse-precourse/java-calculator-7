package calculator.Model;

import calculator.Utils.StringUtils;

public class Calculator {

    public int add(String input) {
        if (input.trim().isEmpty()) {
            return 0;
        }

        // 커스텀 구분자를 추출하고 입력 값에서 숫자 부분 추출
        String delimiter = StringUtils.extractCustomDelimiter(input);
        input = StringUtils.extractNumbersPart(input);

        // 구분자를 사용해 숫자 분리
        String[] numbers = StringUtils.splitInput(input, delimiter);

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