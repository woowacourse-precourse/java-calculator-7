package calculator;

import java.util.List;

public class CalculatorApplication {

    private final StringCalculator calculator;
    private final Splitter splitter;
    private final Input input;
    private final Output output;

    public CalculatorApplication() {
        this.calculator = new StringCalculator();
        this.splitter = new Splitter();
        this.input = new Input();
        this.output = new Output();
    }

    public void run() {
        printStartMessage();
        String expression = inputExpression();
        List<Operand> operands = splitByDelimiters(expression);
        int result = operate(operands);
        printResult(result);
    }

    private void printResult(int result) {
        output.printResult(result);
    }

    private int operate(List<Operand> operands) {
        return calculator.add(operands);
    }

    private List<Operand> splitByDelimiters(String expression) {
        return splitter.split(expression);
    }

    private String inputExpression() {
        return input.readLine();
    }

    private void printStartMessage() {
        output.printStartMessage();
    }
}

