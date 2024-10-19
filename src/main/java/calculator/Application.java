package calculator;

import calculator.application.CalculatorService;
import calculator.ui.CalculatorController;
import calculator.ui.view.CalculatorInputView;
import calculator.ui.view.CalculatorOutputView;

public class Application {

    private static final CalculatorInputView INPUT_VIEW = new CalculatorInputView();
    private static final CalculatorOutputView OUTPUT_VIEW = new CalculatorOutputView();
    private static final CalculatorService SERVICE = new CalculatorService();

    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController(INPUT_VIEW, OUTPUT_VIEW, SERVICE);
        controller.stringAdditionCalculate();
    }

}
