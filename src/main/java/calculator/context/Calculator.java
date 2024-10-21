package calculator.context;

import calculator.strategy.Calculate;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final Calculate operation;
    private final String OUTPUT_MESSAGE = "결과 : ";
    private List<Integer> numbers = new ArrayList<>();
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
    public void calculate() {
        System.out.printf("결과 : %d", operation.computeOperation(this.numbers));
    }


}
