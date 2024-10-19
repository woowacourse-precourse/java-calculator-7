package calculator.service;

import calculator.calculator.StringCalculator;
import calculator.io.IOService;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorService{
    private final StringCalculator calculator;
    private final IOService ioService;

    public CalculatorService(StringCalculator calculator, IOService ioService) {
        this.calculator = calculator;
        this.ioService = ioService;
    }

    public void run() {
        String input = ioService.getInput();
        try {
            long result = calculator.add(input);
            ioService.printResult(result);
        } finally {
            Console.close();
        }
    }
}

