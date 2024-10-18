package calculator.service;

import calculator.dto.request.CalculatorRequest;

import java.util.regex.Pattern;

public class CalculatorService {
    public int calculate(CalculatorRequest request) {
        String input = request.input();

        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";
        String numbers = input;

        if (input.startsWith("//")) {
            input = input.replace("\\n", "\n");
            int delimiterIndex = input.indexOf("\n");

            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 지정 후 올바른 입력이 필요합니다.");
            }

            delimiter = Pattern.quote(input.substring(2, delimiterIndex));
            numbers = input.substring(delimiterIndex + 1);
        }

        String[] nums = numbers.split(delimiter);
        int sum = 0;

        for (String num : nums) {
            if (!num.trim().isEmpty()) {  // 빈 문자열 체크 추가
                try {
                    int parsedNum = Integer.parseInt(num.trim());
                    if (parsedNum < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNum);
                    }
                    sum += parsedNum;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("올바른 숫자가 아닙니다: " + num);
                }
            }
        }

        return sum;
    }
}