package calculator.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValidatorUtilsTest {

  @Test
  void 문자열_유효성() {
    String validInput  = "1,2";
    String invalidInput  = "";
    String NotIncludeNumberInput = ",,,,";
    String validInput_startWithChar = "//a\n//;\n1,2,3a4;5;6";
    String invalidInput_startWithChar = "//a\n1b2,3,4";

    assertThat(Validator.isValidate(validInput)).isEqualTo(true);

    assertThatThrownBy(() -> Validator.isValidate(invalidInput))
            .isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> Validator.isValidate(NotIncludeNumberInput))
            .isInstanceOf(IllegalArgumentException.class);

    assertThat(Validator.isValidate(validInput_startWithChar)).isEqualTo(true);

    assertThatThrownBy(() -> Validator.isValidate(invalidInput_startWithChar))
            .isInstanceOf(IllegalArgumentException.class);
  }

}
