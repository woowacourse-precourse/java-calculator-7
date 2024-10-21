package calculator;

import calculator.calculator.SumCalculator;
import calculator.io.IOHandler;

public class Calculator {

    private final SumCalculator sumCalculator;
    private final IOHandler handler;

    public Calculator(SumCalculator sumCalculator, IOHandler handler) {
        this.sumCalculator = sumCalculator;
        this.handler = handler;
    }

    public void run() {
        handler.startMessage();
        String userInput = handler.getUserInput();
        int result = sumCalculator.splitAndSumWith(userInput);
        handler.showResult(result);
    }
}
