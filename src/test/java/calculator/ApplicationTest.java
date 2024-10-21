package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용_2() {
        assertSimpleTest(() -> {
            run("//|\\n1,2,3|4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 예외_테스트_숫자_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//123\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_양의정수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_양의정수2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1.1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_양의정수3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!@#\n1.1!2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_양의정수4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!@#\n1!0,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_패턴() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/!@#\n1.1!2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_패턴2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//n1.1!2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
