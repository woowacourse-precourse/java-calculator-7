package calculator.view.output;

import calculator.model.CalculationResult;

public class OutputViewImpl implements OutputView {

  private static final String RESULT_PREFIX = "결과 : ";

  @Override
  public void printCalculateResult(CalculationResult calculationResult) {
    System.out.println(RESULT_PREFIX + calculationResult.getCalculatedNumber());
  }
}
