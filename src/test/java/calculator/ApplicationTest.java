package calculator;

import calculator.tool1.StringInput;
import calculator.tool2.Extracts;
import calculator.tool3.Answer;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatRuntimeException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

  @Test
  void 입력_확인() {
    assertSimpleTest(() -> {
      run("//:,\\n1:2:3");

      assertThat(output()).contains("덧셈할 문자열을 입력해 주세요.");

    });
  }


  @Test
  void 입력값_유효성_검사() {
    assertSimpleTest(() -> {

      assertSimpleTest(() ->
          assertThatThrownBy(() -> runException("//-1,2,3"))
              .isInstanceOf(IllegalArgumentException.class)

      );

      assertSimpleTest(() ->
          assertThatThrownBy(() -> runException("//\n\n"))
              .isInstanceOf(IllegalArgumentException.class)

      );


    });
  }

  @Test
  void 예제_케이스_추가(){
    assertSimpleTest(() -> {
      run("1,2:3");
      assertThat(output()).contains("결과 : 6");
    });
  }

  @Test
  void 예제_음수케이스_추가(){
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("//;\\n-1;2"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자가 아니거나 음수입니다.")

    );
  }


  @Override
  public void runMain() {
    Application.main(new String[]{});
  }


}
