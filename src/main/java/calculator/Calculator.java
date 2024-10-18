package calculator;

import java.util.List;

public class Calculator {

    public int calculate(List<String> values) {
        int sum = 0;

        for (String value : values) {
            int num = Integer.parseInt(value);
            if (num <= 0) {
                throw new IllegalArgumentException("0 또는 음수는 입력값에 포함될 수 없습니다.");
            }
            sum += Integer.parseInt(value);
        }

        return sum;
    }

}
