package calculator;

import calculator.controller.InputHandler;
import calculator.controller.OutputHandler;
import calculator.parser.BasicDelimiterParser;
import calculator.parser.BasicNumberParser;
import calculator.parser.DelimiterParser;
import calculator.parser.NumberParser;
import calculator.service.StringSumCalculatorService;
import calculator.service.SumCalculatorService;
import calculator.validator.BasicNumberValidator;
import calculator.validator.NumberValidator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        DelimiterParser delimiterParser = new BasicDelimiterParser();
        NumberParser numberParser = new BasicNumberParser();
        NumberValidator numberValidator = new BasicNumberValidator();

        SumCalculatorService calculatorService = new StringSumCalculatorService(
            delimiterParser, numberParser, numberValidator);

        try {
            String input = inputHandler.readInput();
            String result = calculatorService.calculate(input);
            outputHandler.printResult(result);
        }finally {
            camp.nextstep.edu.missionutils.Console.close();
        }
    }
}
