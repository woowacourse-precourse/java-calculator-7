package calculator;

import java.util.Arrays;

public class SumProcessor implements NumberProcessor {
    @Override
    public int processNumbers(String[] numbers) {
        int sum = 0;

        if (Arrays.equals(numbers, new String[]{"null"})) {
            return 0;
        }

        for (String number : numbers) {
            try {
                if (Integer.parseInt(number) <= 0) {
                    throw new IllegalArgumentException("0 이하의 숫자는 허용되지 않습니다: " + number);
                }
                sum += Integer.parseInt(number.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + number);
            }
        }
        return sum;
    }
}
