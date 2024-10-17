package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자_혼합_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 구분자_패턴_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\\n1;2"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 음수_구분자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n1-2-3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 숫자_자리_문자_예외() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1,*,3"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
