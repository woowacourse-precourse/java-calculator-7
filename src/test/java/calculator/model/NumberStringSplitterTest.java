package calculator.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.Application;
import calculator.view.Message;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class NumberStringSplitterTest extends NsTest {

    @Test
    void 커스텀_문자열이_하이픈이고_음수를_입력하면_하이픈으로_처리() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_문자열이_하이픈이고_하이픈과_음수를_같이_입력하면_예외발생() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("//-\\n1-2--3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.INCLUDE_NEGATIVE_NUMBER.getMessage() + "-3"));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
