package calculator.view.validation;

import static calculator.utils.CalculationUtils.*;

import java.util.Arrays;

public class InputValidation {
  private static final String INVALID_INPUT_DATE_ERROR = "[ERROR] 유효하지 않은 입력값입니다. 다시 입력해 주세요. ";
  private static final String INVALID_CUSTOM_SEPARATOR_ERROR = "(커스텀 구분자 설정이 올바르지 않습니다.)";
  private static final String ONLY_POSITIVE_NUMBER_ALLOWED_ERROR = "(양수만 입력 가능합니다.)";
  private static final String INVALID_SEPARATOR_AND_POSITIVE_NUMBER_ERROR = "(구분자 또는 양수 설정이 올바르지 않습니다.)";

  public static void validateInputString(String inputData) {

    if (inputData == null || inputData.trim().isEmpty()) {
      return;
    }

    checkCustomSeparator(inputData);

    String[] separatedInputData = inputDataToArray(inputData);

    try {
      Arrays.stream(separatedInputData)
          .mapToInt(Integer::parseInt)
          .forEach(value -> {
            if (value < 1) {
              throw new IllegalArgumentException(INVALID_INPUT_DATE_ERROR + ONLY_POSITIVE_NUMBER_ALLOWED_ERROR);
            }
          });

    } catch (Exception e) {
      throw new IllegalArgumentException(INVALID_INPUT_DATE_ERROR + INVALID_SEPARATOR_AND_POSITIVE_NUMBER_ERROR);
    }
  }

  private static void checkCustomSeparator(String inputData) {

    if (inputData.startsWith("//") && !inputData.contains("\\n")) {
      throw new IllegalArgumentException(INVALID_INPUT_DATE_ERROR + INVALID_CUSTOM_SEPARATOR_ERROR);
    }
  }
}
