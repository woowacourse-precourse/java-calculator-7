package calculator.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.Application;
import calculator.view.Message;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class SumCalculatorTest extends NsTest {

    @Test
    void 합계가_long_범위를_넘어가면_예외발생() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(Long.MAX_VALUE + ",1")).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Message.SUM_LONG_OVERFLOW.getMessage()));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
