package calculator;

import calculator.tool1.StringInput;
import calculator.tool2.Extracts;
import calculator.tool3.Answer;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

  @Test
  void 입력_확인() {
    assertSimpleTest(() -> {
      run("//:,\n1:2:3");
      assertThat(output()).contains("덧셈할 문자열을 입력해 주세요.");

    });
  }


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
      Extracts extracts =
          new Extracts("1:2:3", "//:,");

      assertThat(extracts.extractDelimiter()).contains(":", ",");
    });

  }

  @Test
  void 숫자_추출() {
    assertSimpleTest(() -> {
      Extracts extracts =
          new Extracts("1:2:3", "//:,");

      assertThat(extracts.extractDelimiter()).contains(":", ",");
      assertThat(extracts.extractNum()).contains(1, 2, 3);
    });
  }

  @Test
  void 정답_계산() {
    assertSimpleTest(() -> {

      Extracts extracts =
          new Extracts("1:2:3", "//:,");
      extracts.extractDelimiter();
      extracts.extractNum();

      Answer answer = new Answer(extracts.getNums());

      assertThat(answer.calSum()).isEqualTo(6);

    });
  }

  @Test
  void 정답_출력() {
    assertSimpleTest(() -> {
      Extracts extracts =
          new Extracts("1:2:3", "//:,");
      extracts.extractDelimiter();
      extracts.extractNum();

      Answer answer = new Answer(extracts.getNums());

      answer.printAns();

      assertThat(output()).isEqualTo("결과 : 6");
    });
  }


  @Override
  public void runMain() {
    Application.main(new String[]{});
  }


}
