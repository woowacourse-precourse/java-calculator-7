package calculator.config;

import calculator.controller.Controller;
import calculator.model.calculator.Calculator;
import calculator.model.calculator.SumCalculator;
import calculator.model.parser.Parser;
import calculator.model.validator.DefaultValidator;
import calculator.model.validator.InputValidator;
import calculator.view.InputHandler;
import calculator.view.OutputHandler;

public class AppConfig {
    private static AppConfig instance;
    private InputValidator inputValidator;

    private AppConfig() {
        this.inputValidator = new DefaultValidator();
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public Controller controller(String input) {
        Calculator calculator = calculator();
        InputValidator inputValidator = inputValidator();
        Parser parser = parser(input);
        return new Controller(calculator, parser, inputValidator);
    }

    public Calculator calculator() {
        return new SumCalculator();
    }

    public InputValidator inputValidator() {
        return inputValidator;
    }

    public InputHandler inputHandler() {
        return new InputHandler();
    }

    public OutputHandler outputHandler() {
        return new OutputHandler();
    }

    public Parser parser(String input) {
        return new Parser(input, inputValidator);
    }
}
