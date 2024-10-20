package calculator;

import calculator.controller.DelimiterController;
import calculator.controller.StringCalculatorController;
import calculator.model.SumCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        DelimiterController delimiterController = new DelimiterController();
        SumCalculator sumCalculator = new SumCalculator();

        StringCalculatorController stringCalculatorController = new StringCalculatorController.Builder()
                .withInputView(inputView)
                .withOutputView(outputView)
                .withDelimiterController(delimiterController)
                .withSumCalculator(sumCalculator)
                .build();

        stringCalculatorController.runApplication();
    }
}
