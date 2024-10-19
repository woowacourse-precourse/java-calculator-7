package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    String INPUT_ERROR_MESSAGE = "입력값이 맞지 않습니다.";
    String DELIMITER_ERROR_MESSAGE = "구분자가 포함되어 있습니다";

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 빈값_입력() {
        assertSimpleTest(() ->
                assertThatCode(() -> runException("\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(INPUT_ERROR_MESSAGE)
        );
    }

    @Test
    void 커스텀_구분자_여러개_사용() {
        assertSimpleTest(() -> {
            run("//;\\n//^\\n1;2^3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 저장된_구분자_사용_안한_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2^3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DELIMITER_ERROR_MESSAGE)
        );
    }


    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(INPUT_ERROR_MESSAGE)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
