package calculator.calculateTest;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultExceptionTest extends NsTest {
    @Test
    void 커스텀_구분자_구성_앞_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/x\\n2x3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_구성_뒤_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//x\\\n2x3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_위치_중간_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2x3//x\\n2x3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_위치_뒤_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2x3x2x3//x\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_다중_위치_중간_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//x\\n2x//x\\n3x2x3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_다중_위치_뒤_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//x\\n2x3x2x3//x\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_기본_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_커스텀_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//x\\n-1x2x3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 소수_기본_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2.5:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 소수_커스텀_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//x\n1x2.5x3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_특수문자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//x\\n2x3;4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_문자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//x\\n2xax3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_특수문자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,3;4:5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_문자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,a:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 콜론_특수문자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2:3;4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 콜론_문자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2:a:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표_특수문자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,3;4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표_문자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
