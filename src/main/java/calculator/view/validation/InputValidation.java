package calculator.view.validation;

import static calculator.utils.CalculationUtils.*;

import java.util.Arrays;

public class InputValidation {
  private static final String INVALID_INPUT_DATE_ERROR = "[ERROR] 유효하지 않은 입력값입니다. 다시 입력해 주세요.";
  private static String separator = ",|;";

  public static void validateInputString(String inputData) {

    inputData = inputData.trim();

    if (inputData.isEmpty()) {
      return;
    }

    if (inputData.startsWith("//")) {
      inputData = checkCustomSeparator(inputData);
    }

    try {

      Arrays.stream(inputData.split(separator))
          .map(Integer::parseInt)
          .forEach(value -> {
            if (value < 1) {
              throw new IllegalArgumentException(INVALID_INPUT_DATE_ERROR);
            }
          });

    } catch (Exception e) {
      throw new IllegalArgumentException(INVALID_INPUT_DATE_ERROR);
    }
  }

  private static String checkCustomSeparator(String inputData) {

    int separatorEndIndex = inputData.indexOf("\\n");

    if (separatorEndIndex == -1) {
      throw new IllegalArgumentException(INVALID_INPUT_DATE_ERROR);
    }

    String customSeparator = inputData.substring(2, separatorEndIndex);


    separator = escapeSpecialCharacters(customSeparator) + "|" + separator;
    inputData = inputData.substring(separatorEndIndex + 2);

    return inputData;
  }
}
