package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.ApplicationView;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {

    private final CalculatorService calculatorService;
    private final ApplicationView applicationView;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
        this.applicationView = new ApplicationView();
    }

    public String greeting() {
        return applicationView.printRequestInputMessage();
    }

    public String calculate(String input) {
        int result = calculatorService.parseInputAndCalculate(input);

        if (result == 1) {
            return "성공";
        } else {
            return "실패";
        }
    }
}
