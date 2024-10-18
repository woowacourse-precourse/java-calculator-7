package calculator;

import java.util.List;

public class Calculator {
    private final CalculatorInput calculatorInput;
    private final CalculatorOutput calculatorOutput;
    private final CalculatorInputParser calculatorInputParser;

    public Calculator() {
        calculatorInput = new CalculatorInput();
        calculatorOutput = new CalculatorOutput();
        calculatorInputParser = new CalculatorInputParser();
    }

    public void run() {
        String input = calculatorInput.read();
        List<Integer> parsed = calculatorInputParser.parse(input);
        CalculatorNumberList numberList = new CalculatorNumberList(parsed);
        calculatorOutput.print(numberList.sum());
    }
}
