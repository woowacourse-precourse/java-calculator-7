package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CalculatorFailTest extends NsTest {
    @Test
    void 단일_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 추출된_숫자에_0_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 단일_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 크기가_작은_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-10000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 추출된_숫자에_음수_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_정의로_기본_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//,\\n1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자의_길이가_2_이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//ab\\n1ab2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 로마_숫자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("X"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
