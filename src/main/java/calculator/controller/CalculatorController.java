package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

  private final CalculatorService calculatorService;
  private final InputView inputView;
  private final OutputView outputView;

  public CalculatorController() {
    this.calculatorService = new CalculatorService();
    this.inputView = new InputView();
    this.outputView = new OutputView();
  }

  public void run() {
    outputView.printInputMessage();
    String input = inputView.getInput();
    int result = calculatorService.calculate(input);
    outputView.printResultMessage(result);
  }
}
