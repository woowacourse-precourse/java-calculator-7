package calculator.core;

import calculator.input.Input;
import java.util.List;

public class Calculator {

    private final List<Long> numList;

    private Calculator(List<Long> numList) {
        this.numList = numList;
    }

    public static Calculator of(String consoleInput) {
        return new Calculator(Input.of(consoleInput).toLongList());
    }

    public long sum() {
        return numList.stream().mapToLong(x -> x).sum();
    }
}
