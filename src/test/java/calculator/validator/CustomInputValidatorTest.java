package calculator.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CustomInputValidatorTest extends NsTest {

  private final CustomInputValidator validator = new CustomInputValidator();

  @Test
  void 입력값이_null인_경우_예외(){
    assertSimpleTest(() ->{
      assertThatThrownBy(() -> validator.validateInput(null))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("입력값이 null입니다.");
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
          .hasMessageContaining("커스텀 구분자 형식 오류: '\\n'이 필요합니다.");
    });
  }

  @Test
  void 커스텀_구분자_내용_예외(){
    assertSimpleTest(() -> {
      assertThatThrownBy(() -> validator.validateInput("//1\n2,3"))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("커스텀 구분자 내용 오류: 숫자('0-9'), '.', 'e', 'E'는 사용할 수 없습니다.");
    });
  }

  @Test
  void 기본_구분자_잘못된_문자_포함_예외(){
    assertSimpleTest(()->{
      assertThatThrownBy(() -> validator.validateInput("1:2,3@4"))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("허용되지 않는 문자: @가 포함되어 있습니다.");
    });
  }
  @Test
  void 커스텀_구분자_포함_잘못된_문자_포함_예외(){
    assertSimpleTest(()->{
      assertThatThrownBy(() -> validator.validateInput("//#\n1:2,3#4%5"))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("허용되지 않는 문자: %가 포함되어 있습니다.");
    });
  }

  @Override
  public void runMain(){

  }
}
