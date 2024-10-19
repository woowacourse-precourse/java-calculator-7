package calculator.domain;

import calculator.domain.dto.InputRequest;
import calculator.domain.dto.OutputResponse;
import calculator.domain.view.InputView;
import calculator.domain.view.OutputView;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
    }

    public void run() {
        InputRequest input = InputView.getInputRequest();
        OutputResponse result = calculatorService.calculate(input);
        OutputView.outputMessage(result);
    }
}
