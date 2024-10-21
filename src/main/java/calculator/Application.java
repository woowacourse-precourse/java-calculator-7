package calculator;

import static camp.nextstep.edu.missionutils.Console.close;

import calculator.config.CalculatorDependencyConfig;
import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = setupCalculatorController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        try {
            String inputString = inputView.inputCalculationString();
            outputView.outputCalculationResponseDTO(calculatorController.runCalculator(inputString));
        } catch (Exception e) {
            handleError();
        } finally {
            close();
        }
    }

    private static void handleError() {
        throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
    }

    private static CalculatorController setupCalculatorController() {
        CalculatorDependencyConfig calculatorDependencyConfig = new CalculatorDependencyConfig();
        return calculatorDependencyConfig.calculatorController();
    }
}
