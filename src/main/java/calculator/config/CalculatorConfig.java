package calculator.config;

import calculator.controller.CalculatorController;
import calculator.model.CalculatorService;
import calculator.model.CalculatorServiceImpl;
import calculator.model.StringService;
import calculator.model.StringServiceImpl;
import calculator.view.CalculatorInput;
import calculator.view.CalculatorOutput;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorConfig {
    public CalculatorController calculatorController() {
        return new CalculatorController(
                inputView(),
                outputView(),
                calculatorService(),
                stringService()
        );
    }

    public CalculatorService calculatorService() {
        return new CalculatorServiceImpl();
    }

    public StringService stringService() {
        return new StringServiceImpl();
    }

    public InputView inputView() {
        return new CalculatorInput();
    }

    public OutputView outputView() {
        return new CalculatorOutput();
    }
}
