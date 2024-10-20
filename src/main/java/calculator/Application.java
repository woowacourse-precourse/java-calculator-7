package calculator;

import static camp.nextstep.edu.missionutils.Console.close;

import calculator.config.CalculatorDependencyConfig;
import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculatorDependencyConfig calculatorDependencyConfig = new CalculatorDependencyConfig();
        CalculatorController calculatorController = calculatorDependencyConfig.calculatorController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        try {
            outputView.outputCalculationResponseDTO(
                    calculatorController.runCalculator(inputView.inputCalculationString()));
        } catch (Exception e) {
            close();
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
