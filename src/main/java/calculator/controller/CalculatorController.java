package calculator.controller;

import calculator.model.CustomcheckService;
import calculator.view.CalculatorView;
import java.util.List;

public class CalculatorController {

    private final CalculatorView calculatorView;
    private final CustomcheckService customcheckService;

    public CalculatorController(CalculatorView calculatorView, CustomcheckService customcheckService) {
        this.calculatorView = calculatorView;
        this.customcheckService = customcheckService;
    }

    public int sum(List<Integer> checked) {

        int total = 0;
        for (Integer i : checked) {
            total += i;
        }
        return total;
    }


}
