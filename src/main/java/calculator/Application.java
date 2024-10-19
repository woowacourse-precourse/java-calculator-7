package calculator;

import calculator.application.CalculateService;
import calculator.application.impl.PositiveNumberExtractService;
import calculator.ui.CalculatorController;
import calculator.ui.view.CalculatorInputView;
import calculator.ui.view.CalculatorOutputView;

public class Application {

    private static final CalculatorInputView INPUT_VIEW = new CalculatorInputView();
    private static final CalculatorOutputView OUTPUT_VIEW = new CalculatorOutputView();
    private static final PositiveNumberExtractService EXTRACT_SERVICE = new PositiveNumberExtractService();
    private static final CalculateService CALCULATOR_SERVICE = new CalculateService(EXTRACT_SERVICE);

    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController(INPUT_VIEW, OUTPUT_VIEW, CALCULATOR_SERVICE);
        controller.stringAdditionCalculate();
    }

}
