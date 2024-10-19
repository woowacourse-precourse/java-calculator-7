package calculator.processor;

import static calculator.constants.Constants.ERROR_MESSAGE;

import java.util.List;

public class MathProcessor {
    public static Long calculateSum(List<Long> values) {
        Long result = values.stream().mapToLong(Long::longValue).sum();
        // 음수값이 나왔다는 건 오버플로우가 발생했다는 것이므로 error
        if (result < 0)
            throw new IllegalArgumentException(ERROR_MESSAGE);

        return result;
    }
}
