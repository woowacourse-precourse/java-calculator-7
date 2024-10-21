package calculator.controller;

import calculator.domain.CalculatorModel;

public class CalculatorController {

  private final CalculatorModel calculatorModel = new CalculatorModel();

  public void run(String input) {
    double result = calculatorModel.sum(input);
    printResult(result);
  }

  private void printResult(double result) {
    if (result == (int) result) {
      System.out.println("결과 : " + (int) result);
    } else {
      System.out.println("결과 : " + result);
    }
  }
}
