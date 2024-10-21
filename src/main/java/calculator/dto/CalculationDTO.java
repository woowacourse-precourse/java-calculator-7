package calculator.dto;

import calculator.model.CalculationResult;
import java.util.Arrays;

import static calculator.utils.CalculationUtils.inputDataToArray;

public class CalculationDTO {

  private int calculatedNumber;

  public CalculationDTO() {}

  public void calculate(String inputData) {

    String[] separatedInputData = inputDataToArray(inputData);

    int[] numberArray = Arrays.stream(separatedInputData)
        .mapToInt(Integer::parseInt)
        .toArray();

    this.calculatedNumber = sumNumberArray(numberArray);
  }

  private int sumNumberArray(int[] numberArray) {
    return Arrays.stream(numberArray).sum();
  }

  public CalculationResult toModel() {
    return new CalculationResult(this.calculatedNumber);
  }
}
