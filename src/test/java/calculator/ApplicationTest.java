package calculator;

import calculator.exception.Exceptions;
import calculator.model.InputString;
import calculator.model.ResultNumbers;
import calculator.service.MainService;
import camp.nextstep.edu.missionutils.test.NsTest;
import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {

    MainService mainService = new MainService();
    InputString inputString;

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 연속된_콤마_사용_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 연속된 콤마(,,)는 사용할 수 없습니다."));
    }

    @Test
    void 연속된_콜론_사용_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:2::3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 연속된 콜론(::)은 사용할 수 없습니다."));
    }

    @Test
    void 연속된_커스텀_구분자_사용_예외테스트() {

        String userInput = "//!\\n1,2,3:4!!5";

        inputString = new InputString(userInput);

        assertThatThrownBy(() -> runException(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 연속된 커스텀 구분자는 사용할 수 없습니다.");

    }

    @Test
    void 구분자가_처음_나올경우_예외테스트() {

        String userInput = ",1:2,3";

        inputString = new InputString(userInput);

        assertThatThrownBy(() -> runException(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 문자열의 처음에 구분자가 올 수 없습니다.");

    }

    @Test
    void 커스텀_구분자가_처음_나올경우_예외테스트() {

        String userInput = "//!\\n!1,2:3";

        inputString = new InputString(userInput);

        assertThatThrownBy(() -> runException(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 문자열의 처음에 커스텀 구분자가 올 수 없습니다.");

    }

    @Test
    void 커스텀_구분자가_3개_초과일경우_예외테스트() {

        String userInput = "//!\\n//@\\n//#\\n//$\\n1,2,3";

        inputString = new InputString(userInput);

        assertThatThrownBy(() -> runException(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 커스텀 구분자는 3개까지 가능합니다.");

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
