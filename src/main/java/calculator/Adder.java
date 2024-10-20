package calculator;

import java.util.stream.Stream;

import static calculator.Constants.BLANK_AS_ZERO;

public class Adder {

    private final EmptyStringHandler emptyStringHandler = new EmptyStringHandler();

    public int add(String[] seperatedNumbers) {
        if (emptyStringHandler.isEmptyString(seperatedNumbers)) {
            return BLANK_AS_ZERO;
        }

        return Stream.of(seperatedNumbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
