package calculator;

import java.util.Arrays;
import java.util.Objects;

public class Calculator {
    private static final int EMPTY_VALUE = 0;

    public int calculate(String input) {
        validateInput(input);

        if (input.isBlank()){
            return EMPTY_VALUE;
        }

        int[] inputNumbers = Arrays.stream(input.split(Delimiter.getRegularDelimiter()))
                .mapToInt(Integer::parseInt)
                .toArray();

        validateNumbers(inputNumbers);

        return Arrays.stream(inputNumbers).sum();
    }

    private void validateInput(String input) {
        // 여기서 validate 해야 split 때 넘버포맷익셉션 안난다.
        if (Objects.isNull(input)){
            throw new IllegalArgumentException("널 값은 허용되지 않는다.");
        }
    }


    private void validateNumbers(int[] inputNumbers) {
        if (Arrays.stream(inputNumbers).anyMatch(n -> n < 0)) {
            throw new IllegalArgumentException("음수는 허용되지 않는다: " + Arrays.toString(inputNumbers));
        }
    }
}
