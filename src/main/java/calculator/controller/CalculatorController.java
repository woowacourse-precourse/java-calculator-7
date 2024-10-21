package calculator.controller;

import calculator.domain.CalculatorModel;

public class CalculatorController {

  private final CalculatorModel calculatorModel = new CalculatorModel();

  public void run(String input) {
    int result = calculatorModel.sum(input);
    printResult(result);
  }

  private void printResult(int result) {
    System.out.println("결과 : " + result);
  }
}
