package calculator;

import java.util.Arrays;

public class ArrayUtils {

    private void validateNotEmpty(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("더할 값은 null이거나 비어 있을 수 없습니다.");
        }
    }

    private void validatePositive(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("더할 값은 양수여야 합니다.");
        }
    }

    private int parseStringToInt(String str) {
        try {
            validateNotEmpty(str);
            int num = Integer.parseInt(str);
            validatePositive(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("더할 값은 숫자여야 합니다.");
        }
    }

    public int[] convert(String[] inputs) {
        return Arrays.stream(inputs)
                .mapToInt(this::parseStringToInt)
                .toArray();
    }
}
