package calculator.util;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ValidatorUtilsTest {

  @Test
  void 문자열_유효성() {
    String validInput  = "1,2";
    String EmptyValidInput  = "";
    String NotIncludeNumberInput = ",,,,";
    String validInput_startWithChar = "//a\n1,2,3,4:5:6";
    String invalidInput_startWithChar = "//ab\n1,2,3,4:5:6";
    String invalidInput_startWithChar2 = "//a\n1,2,3a4:5b6";
    String nullInput = null;
    String invalidInput_startWithInt = "1,2:3a4";
    String invalidInput_startWithInt2 = "1,2:3,4,";

    // 숫자와 기본 구분자만 있는 경우 테스트
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

    // 커스텀 구분자가 없는데, 기본 구분자 외의 구분자를 사용한 경우 테스트
    assertThatThrownBy(() -> Validator.isValidate(invalidInput_startWithInt))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("잘못된 구분자 사용");

    // 커스텀 구분자가 없는데, 기본 구분자 외의 구분자를 사용한 경우 테스트
    assertThatThrownBy(() -> Validator.isValidate(invalidInput_startWithInt2))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("잘못된 계산 문자열");
  }
}
