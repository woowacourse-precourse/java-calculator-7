package calculator.application;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.input.InputView;
import calculator.view.input.InputViewImpl;
import calculator.view.output.OutputView;
import calculator.view.output.OutputViewImpl;

public class StringAdditionCalculator {

  public void start() {
    CalculatorService calculatorService = new CalculatorService();
    InputView inputView = new InputViewImpl();
    OutputView outputView = new OutputViewImpl();

    CalculatorController calculatorController = new CalculatorController(calculatorService, inputView, outputView);

  }
}
