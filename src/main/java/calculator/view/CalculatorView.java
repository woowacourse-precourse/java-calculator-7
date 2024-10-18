package calculator.view;

import calculator.controller.CalculatorController;
import calculator.dto.request.CalculatorRequest;
import calculator.dto.response.CalculatorResponse;
import calculator.util.Container;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    private final CalculatorController calculatorController;

    public CalculatorView() {
        this.calculatorController = Container.getInstance(CalculatorController.class);
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