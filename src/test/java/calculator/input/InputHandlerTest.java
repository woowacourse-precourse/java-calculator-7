package calculator.input;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputHandlerTest extends NsTest {

    @Test
    void 음수입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Long범위_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("9223372036854775808, 922337203685477580812"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        InputHandler inputHandler = new InputHandler();
        inputHandler.inputProcessor();
    }
}
