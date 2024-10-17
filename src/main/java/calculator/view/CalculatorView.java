package calculator.view;

import calculator.controller.CalculatorController;
import calculator.dto.request.CalculatorRequest;
import calculator.dto.response.CalculatorResponse;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    private final CalculatorController calculatorController;

    public CalculatorView(CalculatorController calculatorController) {
        this.calculatorController = calculatorController;
    }

    public int startProgram() {
        String input = Console.readLine();

        if (input == null) {
            throw new IllegalArgumentException();
        }

        CalculatorResponse response = calculatorController.calculate(CalculatorRequest.from(input));
        return response.result();
    }
}