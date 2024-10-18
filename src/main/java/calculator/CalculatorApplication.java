package calculator;

import calculator.controller.Controller;
import calculator.model.Calculator;
import calculator.model.CustomDelimiterProcessor;
import calculator.model.NumberExtractor;
import calculator.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorApplication {
    public static void run() {
        InputView.printStartMessage();
        String inputString = InputView.getInput();
        initialize().run(inputString);
        Console.close();
    }

    private static Controller initialize() {
        CustomDelimiterProcessor customDelimiterProcessor = new CustomDelimiterProcessor();
        NumberExtractor numberExtractor = new NumberExtractor();
        Calculator calculator = new Calculator();

        return new Controller(customDelimiterProcessor, numberExtractor, calculator);
    }
}
