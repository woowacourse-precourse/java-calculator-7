package calculator.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import calculator.error.ErrorCode;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CustomInputValidatorTest extends NsTest {

  private final CustomInputValidator validator = new CustomInputValidator();

  @Test
  void 입력값이_null인_경우_예외(){
    assertSimpleTest(() ->{
      assertThatThrownBy(() -> validator.validateInput(null))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining(ErrorCode.NULL_INPUT.toString());
    });
  }

  @Test
  void 올바른_커스텀_구분자_형식(){
    assertSimpleTest(() ->{
      assertDoesNotThrow(() -> validator.validateInput("//@\n1@2@3@"));
    });
  }

  @Test
  void 커스텀_구분자_형식_예외(){
    assertSimpleTest(() -> {
      assertThatThrownBy(() -> validator.validateInput("//a1;2;3"))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining(ErrorCode.CUSTOM_DELIMITER_FORMAT_ERROR.toString());
    });
  }

  @Test
  void 커스텀_구분자_길이_예외(){
    assertSimpleTest(() -> {
      assertThatThrownBy(() -> validator.validateInput("//##\n1,2:3"))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("구분자는 한 글자여야 합니다.");
    });
  }

  @Test
  void 커스텀_구분자_내용_예외(){
    assertSimpleTest(() -> {
      assertThatThrownBy(() -> validator.validateInput("//1\n2,3"))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining(ErrorCode.INVALID_DELIMITER_ERROR.toString());
    });
  }

  @Test
  void 기본_구분자_잘못된_문자_포함_예외(){
    assertSimpleTest(()->{
      assertThatThrownBy(() -> validator.validateInput("1:2,3@4#5$6"))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining(ErrorCode.DISALLOWED_CHAR_ERROR.formatMessage("[@, #, $]"));
    });
  }

  @Test
  void 커스텀_구분자_포함_잘못된_문자_포함_예외(){
    assertSimpleTest(()->{
      assertThatThrownBy(() -> validator.validateInput("//#\n1:2,3#4%5$6^7"))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining(ErrorCode.DISALLOWED_CHAR_ERROR.formatMessage("[%, $, ^]"));
    });
  }

  @Override
  public void runMain(){

  }
}
