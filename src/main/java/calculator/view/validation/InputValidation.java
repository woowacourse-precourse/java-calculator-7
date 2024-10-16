package calculator.view.validation;

import java.util.Arrays;

public class InputValidation {

  private static final String VALID_INPUT_REGEX = "[0-9,\\s:]*";
  private static final String INVALID_INPUT_DATE_ERROR = "[ERROR] 유효하지 않은 입력값입니다. 다시 입력해 주세요.";

  public static void validateInputString(String inputData) {

    inputData = inputData.trim();

    if (inputData.isEmpty()) {
      return;
    }

    if (!inputData.matches(VALID_INPUT_REGEX)) {
      throw new IllegalArgumentException(INVALID_INPUT_DATE_ERROR);
    }

    try {
      Arrays.stream(inputData.split("[,:]"))
          .forEach(Integer::parseInt);

    } catch (Exception e) {
      throw new IllegalArgumentException(INVALID_INPUT_DATE_ERROR);
    }
  }
}
