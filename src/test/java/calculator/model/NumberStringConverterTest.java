package calculator.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.Application;
import calculator.view.Message;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class NumberStringConverterTest extends NsTest {

    @Test
    void 숫자_문자열_배열에_숫자가_아닌_값이_포함되어_있으면_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:a:2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.INCLUDE_NOT_NUMBER.getMessage() + "a")
        );
    }

    @Test
    void long으로_표현할_수_없는_숫자가_입력되면_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(Long.MAX_VALUE + "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.TOO_BIG_NUMBER.getMessage() + Long.MAX_VALUE + "1")
        );
    }

    @Test
    void 문자열_중간에_빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("1,,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
