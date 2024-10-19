package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest extends NsTest {

    @Test
    void 커스텀_구분자가_없을_때_허용되지_않는_문자가_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2+3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_있을_때_허용되지_않는_문자가_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//+\\n1~2+3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_없을_때_같은_문자가_연속으로_입력되는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_있을_때_같은_문자가_연속으로_입력되는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//+\\n1,2++3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자를_만들_때_지정_규칙을_지키지_않는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/n+\\n1,2+3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자를_숫자로_입력하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//2\\n1,23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_없을_때_문자열이_문자로_시작하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_없을_때_문자열이_문자로_끝나는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,3,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_있을_때_문자열이_문자로_시작하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//+\\n+1,2+3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_있을_때_문자열이_문자로_끝나는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//+\\n1,2+3+"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
