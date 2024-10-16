package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

  @Test
  void 입력값_유효성_검사() {
    assertSimpleTest(() -> {

      assertSimpleTest(() ->
          assertThatThrownBy(() -> runException("-1,2,3"))
              .isInstanceOf(IllegalArgumentException.class)

      );

      assertSimpleTest(() ->
          assertThatThrownBy(() -> runException("//\n"))
              .isInstanceOf(IllegalArgumentException.class)

      );


    });
  }

  @Test
  void 구분자_추출() {

    assertSimpleTest(() -> {
      run("//:,\n1:2:3");
      assertThat(output()).isEqualTo(":,");
    });

  }


  @Override
  public void runMain() {
    Application.main(new String[]{});
  }


}
