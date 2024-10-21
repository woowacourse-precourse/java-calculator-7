package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.DelimiterExtractor;
import calculator.service.CalculatorService;
import calculator.service.command.Command;
import calculator.service.command.SumCommand;
import calculator.view.CalculatorView;

public class Configuration {

    public static CalculatorController calculatorController() {
        return new CalculatorController(calculatorService(), calculatorView());
    }

    public static CalculatorService calculatorService() {
        CalculatorService calculatorService = new CalculatorService(new DelimiterExtractor());
        calculatorService.setCommand(sumCommand());
        return calculatorService;
    }

    public static Command sumCommand() {
        return new SumCommand();
    }

    public static CalculatorView calculatorView() {
        return new CalculatorView();
    }
}
