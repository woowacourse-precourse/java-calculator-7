package calculator.service;


import calculator.domain.calculator.Calculator;

public class CalculatorService {

  public int calculate(String input) {
    Calculator calculator = Calculator.from(input);
    return calculator.sum();
  }
}
