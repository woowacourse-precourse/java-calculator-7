package calculator.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.controller.InputHandler;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;


public class InputHandlerTest extends NsTest{

  @Test
  void 입력값_테스트(){
    assertSimpleTest(() -> {
      run("1,2:3");

      InputHandler inputhandler = new InputHandler();
      String result = inputhandler.readInput();

      assertThat(result).isEqualTo("1,2:3");
    });
  }
  @Override
  public void runMain(){}
}
