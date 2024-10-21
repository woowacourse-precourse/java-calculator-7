package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,1:4");
            assertThat(output()).contains("결과 : 8");
        });
    }
    @Test
    void 커스텀_구분자_메타문자_사용() {
        assertSimpleTest(() -> {
            run("//*\\n1*2,1:4");
            assertThat(output()).contains("결과 : 8");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_음수값_입력() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_0_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(";,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_구분자_두개_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//q]\n1:2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
