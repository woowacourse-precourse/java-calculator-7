package calculator.controller;

import calculator.domain.StringAddCalculator;
import calculator.service.CalculateService;
import camp.nextstep.edu.missionutils.Console;
import view.SystemView;

public class CalculatorController {

    public static void run() {
        String formula = SystemView.input();

        StringAddCalculator stringAddCalculator = new StringAddCalculator(formula);
        CalculateService calculateService = new CalculateService(stringAddCalculator);
        int calculate = calculateService.calculate();
        SystemView.printResult(calculate);
    }
}
