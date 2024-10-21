package calculator.controller;

import calculator.model.Separator;
import calculator.model.SeparatorValidator;
import calculator.view.InputReader;
import calculator.view.OutputPrinter;

import static calculator.model.Separator.*;

public class CalculatorController {
    public static void run(){

        OutputPrinter.requestInput();
        String input = InputReader.readInput();

        Calculator calculator = new Calculator();
        String token = Separator.checkCustomSeparator(input);

        SeparatorValidator.validateInputEndsWithNumber(token, activeSeparator);
        SeparatorValidator.validateNoConsecutiveDelimiters(token,activeSeparator);

        String[] tokens = splitInput(token);

        int result = calculator.sum(tokens);
        OutputPrinter.printResult(result);

    }
}
