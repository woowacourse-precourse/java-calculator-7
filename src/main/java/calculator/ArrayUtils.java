package calculator;

import java.util.Arrays;

public class ArrayUtils {

    private void validateNotEmpty(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("더할값은 null이거나 비어 있을 수 없습니다.");
        }
    }
}
