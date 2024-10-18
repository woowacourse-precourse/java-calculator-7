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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값검증_커스텀_구분자로_양수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//5\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값검증_커스텀_구분자로_문자열_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//::\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값검증_10억_이상_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1000000000:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 연산중_10억_이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("500000000:500000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 더하기_통합_테스트() {
        assertSimpleTest(() -> {
            run("//a\\n1a2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
