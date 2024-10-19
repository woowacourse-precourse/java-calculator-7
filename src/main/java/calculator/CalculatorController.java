package calculator;

import calculator.service.CalculatorService;
import java.util.List;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final View view;

    private final InputValidator inputValidator;

    public CalculatorController(CalculatorService calculatorService, View view, InputValidator inputValidator) {
        this.calculatorService = calculatorService;
        this.view = view;
        this.inputValidator = inputValidator;
    }

    public String executeInput() {
        view.printMessage();
        return view.input();
    }

    public void executeOutput(Integer result) {
        view.printResultMessage(result);
    }

    public Integer executeCalculation(List<Integer> numbers) {
        return calculatorService.calculate(numbers);
    }

    public Boolean isValidInput(String input) {
        if (!inputValidator.isOnlyOneCustomDeclare(input))
            throw new IllegalArgumentException("하나 이상의 선언부가 존재합니다.");

        if (inputValidator.isContainInvalidChar(input))
            throw new IllegalArgumentException("올바르지 않은 문자가 포함되었습니다.");
        return true;
    }
}
