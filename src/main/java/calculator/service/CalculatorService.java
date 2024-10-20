package calculator.service;

import calculator.dto.request.CalculatorRequest;
import calculator.util.Parser;

public class CalculatorService {

    public int calculate(CalculatorRequest request) {
        int sum = 0;
        String input = request.input();

        if (input.isEmpty()) {
            return 0;
        }

        String[] nums = Parser.parse(input);

        return addition(nums, sum);
    }

    private static int addition(String[] nums, int sum) {
        for (String num : nums) {
            // 빈 문자열 체크
            if (!num.trim().isEmpty()) {
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