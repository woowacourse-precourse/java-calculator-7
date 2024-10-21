package calculator.dto;

import calculator.model.CalculationResult;
import java.util.Arrays;

public class CalculationDTO {

  private int calculatedNumber;

  public CalculationDTO() {}

  public void calculate(String inputData) {
    int[] numberArray = Arrays.stream(inputData.split("[,:]"))
        .filter(number -> !number.isEmpty())
        .mapToInt(Integer::parseInt).toArray();

    this.calculatedNumber = sumNumberArray(numberArray);
  }

  private int sumNumberArray(int[] numberArray) {
    return Arrays.stream(numberArray).sum();
  }

  public CalculationResult toModel() {
    return new CalculationResult(this.calculatedNumber);
  }
}
