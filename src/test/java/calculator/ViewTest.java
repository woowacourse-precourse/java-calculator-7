package calculator;

import calculator.constant.ViewConstants;
import calculator.view.InputView;
import calculator.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ViewTest extends NsTest {

    @Test
    void 입력_테스트() {
        // given
        String input = "1;2;3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        String result = InputView.inputNumbers();

        // then
        Assertions.assertEquals("1;2;3", result);
    }

    @Test
    void 시작_출력_테스트() {
        // when
        OutputView.printStart();

        // then
        assertThat(output()).contains("덧셈할 문자열을 입력해 주세요.");
    }

    @Test
    void 결과_출력_테스트() {
        // given
        String answer = "6";

        // when
        OutputView.printResult(answer);

        // then
        assertThat(output()).contains("결과 : 6");
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
