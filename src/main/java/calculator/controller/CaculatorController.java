package calculator.controller;

import calculator.domain.CaculatorModel;

public class CaculatorController {
  public void input(String input) {
    CaculatorModel calculator = new CaculatorModel(input);
    int result = calculator.sum();
    calculator.printResult(result);
  }
}
