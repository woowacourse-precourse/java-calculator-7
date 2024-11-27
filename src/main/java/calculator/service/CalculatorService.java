package calculator.service;

import calculator.calculator.StringCalculator;
import calculator.calculator.model.InputString;
import calculator.calculator.model.PositiveNumber;
import calculator.io.IOService;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorService {
    private final StringCalculator calculator;
    private final IOService ioService;

    public CalculatorService(StringCalculator calculator, IOService ioService) {
        this.calculator = calculator;
        this.ioService = ioService;
    }

    public void run() {
        String input = ioService.getInput();
        try {
            InputString inputString = new InputString(input);
            PositiveNumber result = calculator.add(inputString);
            ioService.printResult(result.value());
        } finally {
            ioService.close();
        }
    }
}
