package calculator.util;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorUtilsTest {

  @Test
  void 문자열_유효성() {
    String validInput  = "1,2";
    String invalidInput  = "";

    assertThat(Validator.isValidate(validInput)).isEqualTo(true);
    assertThatThrownBy(() -> Validator.isValidate(invalidInput))
            .isInstanceOf(IllegalArgumentException.class);
  }

}
