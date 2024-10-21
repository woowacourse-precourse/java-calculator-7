package calculator.controller;

import calculator.model.CalculationResult;
import calculator.service.CalculatorService;
import calculator.view.input.InputView;
import calculator.view.output.OutputView;

public class CalculatorController {

  private final CalculatorService calculatorService;
  private final InputView inputView;
  private final OutputView outputView;

  public CalculatorController(CalculatorService calculatorService, InputView inputView,
      OutputView outputView) {
    this.calculatorService = calculatorService;
    this.inputView = inputView;
    this.outputView = outputView;
  }

  public void calculate() {
    String inputData = inputView.readInputMessage();

    CalculationResult calculationResult = calculatorService.calculate(inputData);

    outputView.printCalculateResult(calculationResult);
  }
}
