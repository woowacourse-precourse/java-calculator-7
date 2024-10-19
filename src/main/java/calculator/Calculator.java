package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private final Calculate operation;
    private List<Integer> numbers;
    public Calculator(Calculate operation) {
        this.operation = operation;
    }
    // numbers that parsed from input handler will be declared in this method
    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
    // getter methods
    public List<Integer> getNumbers() {
        return numbers;
    }
    public Calculate getOperation() {
        return operation;
    }
    // use strategy
    public int calculate() {
        return operation.computeOperation(numbers);
    }


}
