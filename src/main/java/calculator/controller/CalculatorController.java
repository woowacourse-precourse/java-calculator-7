package calculator.controller;

import calculator.command.SumCommand;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {

    public void run() {
        final CalculatorService calculator = new CalculatorService();

        final String input = CalculatorView.printStartView();

        calculator.setCommand(new SumCommand());

        CalculatorView.printEndView(calculator.calculate(input));
    }
}
