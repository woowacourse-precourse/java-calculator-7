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
    void 커스텀_구분자_혼합() {
        assertSimpleTest(() -> {
            run("//#\\n1#2,3");
            assertThat(output()).contains("결과 : 6");
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
    void 임의_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2*3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_테스트() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_숫자_제외() {
        assertSimpleTest(() -> {
            run("//&\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자_없이_숫자만() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    void 숫자와_문자_혼합() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,b"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자와_임의_구분자_혼합() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//#\\n1#2,3&4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
