package calculator;

import calculator.application.CalculateService;
import calculator.application.ExtractService;
import calculator.application.SeparateService;
import calculator.application.impl.PositiveNumberExtractService;
import calculator.application.impl.StringCalculatorSeparateService;
import calculator.ui.CalculatorController;
import calculator.ui.view.CalculatorInputView;
import calculator.ui.view.CalculatorOutputView;

public class Application {
    public static void main(String[] args) {
        CalculatorInputView inputView = new CalculatorInputView();
        CalculatorOutputView outputView = new CalculatorOutputView();
        ExtractService extractService = new PositiveNumberExtractService();
        SeparateService separateService = new StringCalculatorSeparateService();
        CalculateService calculateService = new CalculateService(separateService, extractService);
        CalculatorController controller = new CalculatorController(inputView, outputView, calculateService);

        controller.stringAdditionCalculate();
    }

}
