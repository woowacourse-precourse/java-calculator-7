package calculator;

import java.util.stream.Stream;

import static calculator.Constants.BLANK_AS_ZERO;

public class Adder {

    private final EmptyInputHandler emptyInputHandler = new EmptyInputHandler();

    public int add(String[] seperatedNumbers) {
        if (emptyInputHandler.isEmptyString(seperatedNumbers)) {
            return BLANK_AS_ZERO;
        }

        return Stream.of(seperatedNumbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
