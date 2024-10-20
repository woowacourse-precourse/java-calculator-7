package calculator.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import calculator.error.ErrorCode;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest{

  private final NumberValidator numberValidator = new BasicNumberValidator();
  @Test
  public void 빈_숫자_예외(){
    assertThatThrownBy(() -> numberValidator.validateNumber(""))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ErrorCode.EMPTY_NUMBER_ERROR.toString());
  }

  @Test
  public void 음수_예외(){
    assertThatThrownBy(() -> numberValidator.validateNumber("-123"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ErrorCode.NEGATIVE_NUMBER_ERROR.toString());
  }

  @Test
  public void 잘못된_숫자_형식_예외(){
    assertThatThrownBy(() -> numberValidator.validateNumber("abc"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ErrorCode.INVALID_NUMBER_FORMAT.toString());
  }

  @Test
  public void 올바른_정수_입력(){
    assertDoesNotThrow(() -> numberValidator.validateNumber("123"));
  }

  @Test
  public void 올바른_소수_입력(){
    assertDoesNotThrow(() -> numberValidator.validateNumber("123.456"));
  }

  @Test
  public void 올바른_과학적_표기법_입력(){
    assertDoesNotThrow(() -> numberValidator.validateNumber("4e-2"));
  }
}
