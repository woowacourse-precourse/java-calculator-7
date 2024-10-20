package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class CalculatorControllerTest extends NsTest {

    @Test
    void 입력이_없는_경우_0을_반환한다() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자를_사용하여_계산한다() {
        assertSimpleTest(() -> {
            run("//;\\n1,2,5;10:10");
            assertThat(output()).contains("결과 : 28");
        });
    }

    @Test
    void 음수를_입력하면_예외를_반환한다() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_형식의_값을_입력하면_예외가_발생한다() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-one,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
