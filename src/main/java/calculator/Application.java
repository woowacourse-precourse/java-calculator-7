package calculator;

import calculator.model.CalculationRequestDTO;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = InputView.readInput();

        try {
            CalculationRequestDTO requestDTO = new CalculationRequestDTO(input);
            int result = CalculatorService.calculate(requestDTO);
            ResultView.displayResult(result);
        } catch (IllegalArgumentException e) {
            ResultView.displayError(e.getMessage());
            throw e;
        }
    }
}
