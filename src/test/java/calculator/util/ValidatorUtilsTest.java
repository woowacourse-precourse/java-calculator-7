package calculator.util;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ValidatorUtilsTest extends NsTest {

  @Test
  void 문자열_유효성() {
    String validInput  = "1,2";
    String EmptyValidInput  = "";
    String NotIncludeNumberInput = ",,,,";
    String validInput_startWithChar = "//a\n1,2,3,4:5:6";
    String invalidInput_startWithChar = "//ab\n1,2,3a4:5:6";
    String invalidInput_startWithChar2 = "//a\n1,2,3a4:5b6";

    String nullInput = null;
    assertThat(Validator.isValidate(validInput)).isEqualTo(true);

      assertThat(Validator.isValidate(EmptyValidInput)).isEqualTo(true);


    assertThatThrownBy(() -> Validator.isValidate(NotIncludeNumberInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("case2");

    assertThat(Validator.isValidate(validInput_startWithChar)).isEqualTo(true);

    assertThatThrownBy(() -> Validator.isValidate(invalidInput_startWithChar))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("커스텀 구분자 생성 오류");
    
    assertThatThrownBy(() -> Validator.isValidate(invalidInput_startWithChar2))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("잘못된 구분자 사용");
    
    assertThatThrownBy(() -> Validator.isValidate(nullInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("null");
  }

  @Override
  protected void runMain() {

  }
}
