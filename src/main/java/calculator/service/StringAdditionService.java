package calculator.service;

import calculator.utils.StringUtils;

public class StringAdditionService {
    public static int calculateSum(String input) {
        if (StringUtils.isEmpty(input)) {
            return 0;
        }

        String[] tokens = StringUtils.extractNumbers(input);
        int sum = 0;
        for (String token : tokens) {
            if (StringUtils.isEmpty(token)) {
                continue;
            }
            try {
                int number = Integer.parseInt(token.trim());
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력: " + token);
            }
        }
        return sum;
    }
}
